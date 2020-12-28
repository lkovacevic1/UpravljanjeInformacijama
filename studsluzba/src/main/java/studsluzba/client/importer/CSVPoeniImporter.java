package studsluzba.client.importer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studsluzba.model.DrziPredmet;
import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.PredispitneObaveze;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.services.IndeksService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudentService;

@Component
public class CSVPoeniImporter {
	
	@Autowired
	StudentService studService;
	
	@Autowired
	SifarniciService sifarniciService;
	
	@Autowired
	IndeksService indeksService;
	
	static int j = 0;
	
	// vraca poruku
	public String importCSV(File f) {
		Scanner sc = null;
		StringBuilder poruka = new StringBuilder();
		
		try {
			sc = new Scanner(f,"UTF-8");
			String linijaNazivaPredmeta = sc.nextLine(); //Izvucemo ime predmeta
			String[] imePredmetaSaZarezima = linijaNazivaPredmeta.split(",");
			String nazivPredmeta = imePredmetaSaZarezima[0];
			String duplaGodina = sc.nextLine();
			String[] stringGodina = duplaGodina.split("/");
			int godinaPredmeta = Integer.parseInt(stringGodina[0]); //Izvucemo godinu predvanja predmeta
			
			Predmet predmet = sifarniciService.selectIdPredmeta(nazivPredmeta);
			
			SkolskaGodina skGodina = sifarniciService.selectSkolskaGodina(godinaPredmeta);
			
			DrziPredmet drziPredmet = sifarniciService.selectDrziPredmet(predmet, skGodina);
			Nastavnik nastavnik = drziPredmet.getNastavnik();	//Izvucemo nastavnika koji drzi predmet za datu godinu
			
			String obaveze = sc.nextLine();
			String[] podaciObaveze = obaveze.split(",");
			
			String kolokvijum = podaciObaveze[5];
			int maksNaKolokvijumu = 25;
			PredispitneObaveze obavezaKolokvijum = sifarniciService.savePredispitnuObavezu(maksNaKolokvijumu, kolokvijum, nastavnik, predmet, skGodina);
			
			String test = podaciObaveze[6];
			int maksNaTestu = 25;
			PredispitneObaveze obavezaTest = sifarniciService.savePredispitnuObavezu(maksNaTestu, test, nastavnik, predmet, skGodina);
			
			String kviz = podaciObaveze[7];
			int maksNakvizu = 10;
			PredispitneObaveze obavezaKviz = sifarniciService.savePredispitnuObavezu(maksNakvizu, kviz, nastavnik, predmet, skGodina);
			
			String rokJun = podaciObaveze[8];
			IspitniRok ispitniRokJun = sifarniciService.saveIspitniRok(rokJun, skGodina);
			Ispit ispitJun = sifarniciService.saveIspit(ispitniRokJun, nastavnik, predmet, rokJun);
			
			String rokJul = podaciObaveze[9];
			IspitniRok ispitniRokJul = sifarniciService.saveIspitniRok(rokJul, skGodina);
			Ispit ispitJul = sifarniciService.saveIspit(ispitniRokJul, nastavnik, predmet, rokJul);
			
			String rokAvgust = podaciObaveze[10];
			IspitniRok ispitniAvgust = sifarniciService.saveIspitniRok(rokAvgust, skGodina);
			Ispit ispitAvgust = sifarniciService.saveIspit(ispitniAvgust, nastavnik, predmet, rokAvgust);
			
			String rokSeptembar = podaciObaveze[11];
			System.out.println("Septembarski rok: " + rokSeptembar);
			IspitniRok ispitniSeptembar = sifarniciService.saveIspitniRok(rokSeptembar, skGodina);
			System.out.println("Ispit septembar je: " + ispitniSeptembar);
			Ispit ispitSeptembar = sifarniciService.saveIspit(ispitniSeptembar, nastavnik, predmet, rokSeptembar);
			
			int prolazi = 0;
			int brojSacuvanihStudenata = 0;
			while(sc.hasNext()) {
				prolazi++;
				
				String line = sc.nextLine();
				String[] delovi = line.split(",");
				String studProgram = delovi[0];
				int broj = Integer.parseInt(delovi[1]);
				int godina = Integer.parseInt(delovi[2]);
				String prezime = delovi[3];
				String ime = delovi[4];

				Indeks si = indeksService.getIndeks(studProgram, broj, godina);
				if(si==null) {  // student ne postoji dodajemo ga, u realnom sistemu se ovo ne moze desiti
					si = indeksService.saveStudentAndIndex(ime, prezime, studProgram, broj, godina);
					brojSacuvanihStudenata++;
				}
				
				j++;
				System.out.println("Red: " + j);
				int duzinaNiza = delovi.length - 1;
				
				System.out.println("Duzina reda je: " + duzinaNiza);
				
				if(duzinaNiza < 5)
					continue;
				
				float poeniKolokvijum = 0;
				if(!delovi[5].isEmpty()) {
					poeniKolokvijum = Float.parseFloat(delovi[5]);
					sifarniciService.saveOsvojenePredispitneObaveze(poeniKolokvijum, si, obavezaKolokvijum);
				}
				
				
				if(duzinaNiza < 6)
					continue;
				float poeniTest = 0;
				if(!delovi[6].isEmpty()) {
					poeniTest = Float.parseFloat(delovi[6]);
					sifarniciService.saveOsvojenePredispitneObaveze(poeniTest, si, obavezaTest);
				}
				
				
				if(duzinaNiza < 7)
					continue;
				float poeniKviz = 0;
				
				if(!delovi[7].isEmpty()) {
					poeniKviz = Float.parseFloat(delovi[7]);
					sifarniciService.saveOsvojenePredispitneObaveze(poeniKviz, si, obavezaKviz);
				}
				
				
				float ukupnoPredispitni = poeniKolokvijum + poeniTest + poeniKviz;
				
				
				System.out.println("Pre rokova prolazi: " + prolazi);
				List<Ispit> ispiti = new ArrayList<Ispit>();
				ispiti.add(ispitJun);
				ispiti.add(ispitJul);
				ispiti.add(ispitAvgust);
				ispiti.add(ispitSeptembar);
				System.out.println("ISPITI SU: " + ispiti.get(0) + " " + ispiti.get(1) + " " + ispiti.get(2) + " " + ispiti.get(3));
				
				PolozenPredmet polozenPredmet = new PolozenPredmet();
				if(duzinaNiza >= 8) {
					System.out.println("Id ispita za ispitni rok je: " + ispiti.get(duzinaNiza-8));
					polozenPredmet = sifarniciService.savePolozenPredmet(Float.parseFloat(delovi[duzinaNiza]), si, ispiti.get(duzinaNiza-8), predmet, ukupnoPredispitni);
					sifarniciService.savePrijavaIspita(si, ispiti.get(duzinaNiza - 8));
					indeksService.dodajPoene(si, ukupnoPredispitni + Float.parseFloat(delovi[duzinaNiza]));
					sifarniciService.saveIzlazakNaIspit(polozenPredmet, true);
					duzinaNiza--;
					while(duzinaNiza >= 8) {
						if(!delovi[duzinaNiza].isEmpty()) {
							polozenPredmet = sifarniciService.saveNePolozenPredmet(Float.parseFloat(delovi[duzinaNiza]), si, ispiti.get(duzinaNiza-8), predmet, ukupnoPredispitni);
							sifarniciService.savePrijavaIspita(si, ispiti.get(duzinaNiza - 8));
							sifarniciService.saveIzlazakNaIspit(polozenPredmet, false);
							System.out.println(si.getIdIndeks());
						}
						duzinaNiza--;
					}
				}
			}
			poruka.append("Broj sacuvanih studenata: ");
			poruka.append(brojSacuvanihStudenata);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sc.close();
		
		}
		return poruka.toString();
	}

}
