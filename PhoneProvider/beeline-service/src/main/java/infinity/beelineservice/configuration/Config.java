package infinity.beelineservice.configuration;

import infinity.beelineservice.model.entity.Beeline;
import infinity.beelineservice.repository.BeelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final BeelineRepository beelineRepository;

    @PostConstruct
    public void saveData(){
        List<Beeline> beelineList = new ArrayList<>();
        Beeline abdulloh = new Beeline();
        abdulloh.setFullName("Abdulloh Qosimov");
        abdulloh.setPhoneNumber("+998903202114");
        abdulloh.setAccount(1000000d);
        abdulloh.setPassportNumber("AA0419932");
        abdulloh.setGmail("abdulloh@gmail.com");
        beelineList.add(abdulloh);


        Beeline ziyodilla = new Beeline();
        ziyodilla.setFullName("Ziyodilla Jumabayev");
        ziyodilla.setPhoneNumber("+998901112233");
        ziyodilla.setAccount(2000000d);
        ziyodilla.setPassportNumber("AA1122333");
        ziyodilla.setGmail("");
        beelineList.add(ziyodilla);

        Beeline fotima = new Beeline();
        fotima.setFullName("Fotima Qosimova");
        fotima.setPhoneNumber("998902223344");
        fotima.setAccount(10000000d);
        fotima.setPassportNumber("FA3333222");
        fotima.setGmail("abdulloh@gmail.com");
        beelineList.add(fotima);
        beelineRepository.saveAll(beelineList);
    }
}
