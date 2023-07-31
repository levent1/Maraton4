package com.bilgeadam.Service;

import com.bilgeadam.manager.ISehirManager;
import com.bilgeadam.repository.ITahminRepository;
import com.bilgeadam.repository.entity.Sehir;
import com.bilgeadam.repository.entity.Tahmin;
import com.bilgeadam.utility.ServiceManager;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

public class TahminService extends ServiceManager<Tahmin,Long>{
    private  final ITahminRepository tahminRepository;
    private final ISehirManager sehirManager;


    public TahminService(ITahminRepository tahminRepository, ISehirManager sehirManager) {
        super(tahminRepository);
        this.tahminRepository =  tahminRepository;
        this.sehirManager = sehirManager;
    }

    @Transactional
    public String sor() {
        Random random=new Random();
        int sayi= random.nextInt(1,3);//eklediğimiz 2 adet şehir var onlardan birini bize dönecek soru olarak arttırılabilir
        List<Sehir> sehirList= (List<Sehir>) sehirManager.findall();
        Sehir sehir=sehirList.get( sayi);
        return "Soru"+sehir.getBolge()+ " bölgemizdedir" +"Kopya:"+sehir.getKopaya();

    }
}
