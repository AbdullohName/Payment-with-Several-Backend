package infinity.perfectumservice.configuration;

import infinity.perfectumservice.model.entity.Perfectum;
import infinity.perfectumservice.repository.PerfectumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Autowired
    private PerfectumRepository perfectumRepository;

    @PostConstruct
    public void saveData(){
        List<Perfectum> perfectumList = new ArrayList<>();
        Perfectum abdulloh = new Perfectum();
        abdulloh.setFullName("Abdulloh Qosimov");
        abdulloh.setPhoneNumber("+998988888888");
        abdulloh.setAccount(1000000d);
        abdulloh.setPassportNumber("AA0419932");
        abdulloh.setGmail("abdulloh@gmail.com");
        perfectumList.add(abdulloh);


        Perfectum ziyodilla = new Perfectum();
        ziyodilla.setFullName("Ziyodilla Jumabayev");
        ziyodilla.setPhoneNumber("+998981112233");
        ziyodilla.setAccount(2000000d);
        ziyodilla.setPassportNumber("AA1122333");
        ziyodilla.setGmail("");
        perfectumList.add(ziyodilla);

        Perfectum fotima = new Perfectum();
        fotima.setFullName("Fotima Qosimova");
        fotima.setPhoneNumber("998988000000");
        fotima.setAccount(10000000d);
        fotima.setPassportNumber("FA3333222");
        fotima.setGmail("abdulloh@gmail.com");
        perfectumList.add(fotima);

        perfectumRepository.saveAll(perfectumList);
    }
}
