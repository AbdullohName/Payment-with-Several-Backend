package infinity.uzmobileservice.configuration;

import infinity.uzmobileservice.model.entity.Uzmobile;
import infinity.uzmobileservice.repository.UzmobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Autowired
    private UzmobileRepository uzmobileRepository;

    @PostConstruct
    public void saveData(){
        List<Uzmobile> uzmobileList = new ArrayList<>();
        Uzmobile abdulloh = new Uzmobile();
        abdulloh.setFullName("Abdulloh Qosimov");
        abdulloh.setPhoneNumber("+998998677178");
        abdulloh.setAccount(1000000d);
        abdulloh.setPassportNumber("AA0419932");
        abdulloh.setGmail("abdulloh@gmail.com");
        uzmobileList.add(abdulloh);


        Uzmobile ziyodilla = new Uzmobile();
        ziyodilla.setFullName("Ziyodilla Jumabayev");
        ziyodilla.setPhoneNumber("+998999999999");
        ziyodilla.setAccount(2000000d);
        ziyodilla.setPassportNumber("AA1122333");
        ziyodilla.setGmail("");
        uzmobileList.add(ziyodilla);

        Uzmobile fotima = new Uzmobile();
        fotima.setFullName("Fotima Qosimova");
        fotima.setPhoneNumber("998999000000");
        fotima.setAccount(10000000d);
        fotima.setPassportNumber("FA3333222");
        fotima.setGmail("abdulloh@gmail.com");
        uzmobileList.add(fotima);

        uzmobileRepository.saveAll(uzmobileList);
    }
}
