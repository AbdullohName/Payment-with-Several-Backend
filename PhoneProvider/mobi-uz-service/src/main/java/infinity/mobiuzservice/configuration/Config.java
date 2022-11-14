package infinity.mobiuzservice.configuration;

import infinity.mobiuzservice.model.entity.MobiUz;
import infinity.mobiuzservice.repository.MobiUzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class Config {
    @Autowired
    private MobiUzRepository mobiUzRepository;

    @PostConstruct
    public void saveData(){
        List<MobiUz> mobiUzList = new ArrayList<>();
        MobiUz abdulloh = new MobiUz();
        abdulloh.setFullName("Abdulloh Qosimov");
        abdulloh.setPhoneNumber("+99897 7777777");
        abdulloh.setAccount(1000000d);
        abdulloh.setPassportNumber("AA0419932");
        abdulloh.setGmail("abdulloh@gmail.com");
        mobiUzList.add(abdulloh);


        MobiUz ziyodilla = new MobiUz();
        ziyodilla.setFullName("Ziyodilla Jumabayev");
        ziyodilla.setPhoneNumber("+998977656655");
        ziyodilla.setAccount(2000000d);
        ziyodilla.setPassportNumber("AA1122333");
        ziyodilla.setGmail("");
        mobiUzList.add(ziyodilla);

        MobiUz fotima = new MobiUz();
        fotima.setFullName("Fotima Qosimova");
        fotima.setPhoneNumber("99897 7000000");
        fotima.setAccount(10000000d);
        fotima.setPassportNumber("FA3333222");
        fotima.setGmail("abdulloh@gmail.com");
        mobiUzList.add(fotima);
        mobiUzRepository.saveAll(mobiUzList);
    }
}
