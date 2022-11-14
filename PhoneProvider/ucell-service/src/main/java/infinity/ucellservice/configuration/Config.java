package infinity.ucellservice.configuration;

import infinity.ucellservice.model.entity.Ucell;
import infinity.ucellservice.model.entity.UcellHistory;
import infinity.ucellservice.repository.UcellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Autowired
    private UcellRepository ucellRepository;

    @PostConstruct
    public void saveData(){
        List<Ucell> ucellList = new ArrayList<>();
        Ucell abdulloh = new Ucell();
        abdulloh.setFullName("Abdulloh Qosimov");
        abdulloh.setPhoneNumber("+998934444444");
        abdulloh.setAccount(1000000d);
        abdulloh.setPassportNumber("AA0419932");
        abdulloh.setGmail("abdulloh@gmail.com");
        ucellList.add(abdulloh);


        Ucell ziyodilla = new Ucell();
        ziyodilla.setFullName("Ziyodilla Jumabayev");
        ziyodilla.setPhoneNumber("+998933333333");
        ziyodilla.setAccount(2000000d);
        ziyodilla.setPassportNumber("AA1122333");
        ziyodilla.setGmail("");
        ucellList.add(ziyodilla);

        Ucell fotima = new Ucell();
        fotima.setFullName("Fotima Qosimova");
        fotima.setPhoneNumber("998940617178");
        fotima.setAccount(10000000d);
        fotima.setPassportNumber("FA3333222");
        fotima.setGmail("abdulloh@gmail.com");
        ucellList.add(fotima);

        ucellRepository.saveAll(ucellList);
    }
}
