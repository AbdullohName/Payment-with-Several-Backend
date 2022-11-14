package com.example.paynet.service.Impl;

import com.example.paynet.feign.card.HumoPlaceHolder;
import com.example.paynet.feign.card.UzcardPlaceHolder;
import com.example.paynet.feign.phoneProvider.*;
import com.example.paynet.mapper.PhoneNumberPaymentMapper;
import com.example.paynet.mapper.WithDrawMoneyMapper;
import com.example.paynet.model.dto.PhoneNumberPaymentDto;
import com.example.paynet.model.dto.ResponseDto;
import com.example.paynet.model.dto.WithdrawMoneyDto;
import com.example.paynet.model.entity.Provider;
import com.example.paynet.repository.PhoneNumberPaymentRepository;
import com.example.paynet.repository.ProviderRepository;
import com.example.paynet.service.PhonePaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service @RequiredArgsConstructor
public class PhonePaymentServiceImpl implements PhonePaymentService {
    private final PhoneNumberPaymentRepository phoneNumberPaymentRepository;
    private final ProviderRepository providerRepository;
    //////////////////////////////// Repository

    private final HumoPlaceHolder humoPlaceHolder;
    private final UzcardPlaceHolder uzcardPlaceHolder;
    private final BeelinePlaceHolder beelinePlaceHolder;
    private final UcellPlaceHolder ucellPlaceHolder;
    private final UzMobilePlaceHolder uzMobilePlaceHolder;
    private final MobiUzPlaceHolder mobiUzPlaceHolder;
    private final PerfectumPlaceHolder perfectumPlaceHolder;
    //////////////////////////////PlaceHolder

    public Long transActionId;
    private PhoneNumberPaymentDto phoneNumberPaymentDto;
    private String uzCardNumberForService = "8600 3333 3333 3333";
    private String humoCardNumberForService = "9860 3333 3333 3333";

    private final PhoneNumberPaymentMapper phoneNumberPaymentMapper;
    @Override
    public ResponseDto<Long> beeline(PhoneNumberPaymentDto phoneNumberPaymentDto1) {
        transActionId = phoneNumberPaymentRepository.countPhoneNumberPaymentBy();
        phoneNumberPaymentDto = phoneNumberPaymentDto1;
        phoneNumberPaymentDto.setTransAcId(transActionId + 1); //todo transaction idni serial qilish kere
        if((phoneNumberPaymentDto.getPhoneNumber().startsWith("+99890") || phoneNumberPaymentDto.getPhoneNumber().startsWith("+99891")) && phoneNumberPaymentDto.getProviderName().equals("beeline")) {

            ResponseDto<String> responseDto = beelinePlaceHolder.Beeline(phoneNumberPaymentDto);
            if (responseDto.getSuccess()) {
                phoneNumberPaymentRepository.save(phoneNumberPaymentMapper.toEntity(phoneNumberPaymentDto));
                new Thread(this::run).start();
                return ResponseDto.<Long>builder().code(0).success(true).message("Please wait").data(transActionId).build();
            }
        }
        return ResponseDto.<Long>builder().code(-1).success(false).message("Error").build();
    }

    @Override
    public ResponseDto<Long> ucell(PhoneNumberPaymentDto phoneNumberPaymentDto) {
        transActionId = Long.valueOf(phoneNumberPaymentRepository.countPhoneNumberPaymentBy());
        phoneNumberPaymentDto.setId(transActionId + 1); //todo transaction idni serial qilish kere
        this.phoneNumberPaymentDto = phoneNumberPaymentDto;
        if((phoneNumberPaymentDto.getPhoneNumber().startsWith("+99893") || phoneNumberPaymentDto.getPhoneNumber().startsWith("+99894")) && phoneNumberPaymentDto.getProviderName().equals("ucell")) {

            ResponseDto<String> responseDto = ucellPlaceHolder.Ucell(phoneNumberPaymentDto);
            if (responseDto.getSuccess()) {
                phoneNumberPaymentRepository.save(phoneNumberPaymentMapper.toEntity(phoneNumberPaymentDto));
                new Thread(this::run).start();
                return ResponseDto.<Long>builder().code(0).success(true).message("Please wait").data(transActionId).build();
            }
        }
        return ResponseDto.<Long>builder().code(-1).success(false).message("Error").build();
    }

    @Override
    public ResponseDto<Long> uzMobile(PhoneNumberPaymentDto phoneNumberPaymentDto) {
        transActionId = Long.valueOf(phoneNumberPaymentRepository.countPhoneNumberPaymentBy());
        phoneNumberPaymentDto.setId(transActionId + 1); //todo transaction idni serial qilish kere
        this.phoneNumberPaymentDto = phoneNumberPaymentDto;
        if((phoneNumberPaymentDto.getPhoneNumber().startsWith("+99899") || phoneNumberPaymentDto.getPhoneNumber().startsWith("+99895")) && phoneNumberPaymentDto.getProviderName().equals("beeline")) {

            ResponseDto<String> responseDto = uzMobilePlaceHolder.UzMobile(phoneNumberPaymentDto);
            if (responseDto.getSuccess()) {
                phoneNumberPaymentRepository.save(phoneNumberPaymentMapper.toEntity(phoneNumberPaymentDto));
                new Thread(this::run).start();
                return ResponseDto.<Long>builder().code(0).success(true).message("Please wait").data(transActionId).build();
            }
        }
        return ResponseDto.<Long>builder().code(-1).success(false).message("Error").build();
    }

    @Override
    public ResponseDto<Long> perfectum(PhoneNumberPaymentDto phoneNumberPaymentDto) {
        transActionId = Long.valueOf(phoneNumberPaymentRepository.countPhoneNumberPaymentBy());
        phoneNumberPaymentDto.setId(transActionId + 1); //todo transaction idni serial qilish kere
        this.phoneNumberPaymentDto = phoneNumberPaymentDto;
        if((phoneNumberPaymentDto.getPhoneNumber().startsWith("+99898")) && phoneNumberPaymentDto.getProviderName().equals("beeline")) {

            ResponseDto<String> responseDto = perfectumPlaceHolder.Perfectum(phoneNumberPaymentDto);
            if (responseDto.getSuccess()) {
                phoneNumberPaymentRepository.save(phoneNumberPaymentMapper.toEntity(phoneNumberPaymentDto));
                new Thread(this::run).start();
                return ResponseDto.<Long>builder().code(0).success(true).message("Please wait").data(transActionId).build();
            }
        }
        return ResponseDto.<Long>builder().code(-1).success(false).message("Error").build();
    }

    @Override
    public ResponseDto<Long> mobiUz(PhoneNumberPaymentDto phoneNumberPaymentDto) {
        transActionId = Long.valueOf(phoneNumberPaymentRepository.countPhoneNumberPaymentBy());
        phoneNumberPaymentDto.setId(transActionId + 1); //todo transaction idni serial qilish kere
        this.phoneNumberPaymentDto = phoneNumberPaymentDto;
        if((phoneNumberPaymentDto.getPhoneNumber().startsWith("+99897") || phoneNumberPaymentDto.getPhoneNumber().startsWith("+99891")) && phoneNumberPaymentDto.getProviderName().equals("beeline")) {

            ResponseDto<String> responseDto = mobiUzPlaceHolder.MobiUz(phoneNumberPaymentDto);
            if (responseDto.getSuccess()) {
                phoneNumberPaymentRepository.save(phoneNumberPaymentMapper.toEntity(phoneNumberPaymentDto));
                new Thread(this::run).start();
                return ResponseDto.<Long>builder().code(0).success(true).message("Please wait").data(transActionId).build();
            }
        }
        return ResponseDto.<Long>builder().code(-1).success(false).message("Error").build();
    }


    public void run() {
        WithdrawMoneyDto withdrawMoneyDto = WithDrawMoneyMapper.moneyDto(phoneNumberPaymentDto);
        Optional<Provider> provider = providerRepository.findByName(phoneNumberPaymentDto.getProviderName());
        int checkToPayment = 0;
        if(provider.isPresent()) {
            ResponseDto<String> responseDto = new ResponseDto<>();
            if(withdrawMoneyDto.getCardNumberTakeOff().startsWith("8600")) {
                withdrawMoneyDto.setCardNumberAddMoney(provider.get().getUzCardNumber());
                responseDto = uzcardPlaceHolder.withdrawMoney(withdrawMoneyDto);
                if(responseDto.getSuccess()) {
                    System.out.println(withdrawMoneyDto.getPrice());
                    checkToPayment++;

                    withdrawMoneyDto.setCardNumberTakeOff(withdrawMoneyDto.getCardNumberAddMoney());
                    withdrawMoneyDto.setCardNumberAddMoney(uzCardNumberForService);
                    withdrawMoneyDto.setPrice(withdrawMoneyDto.getPrice() * 0.04);
                    responseDto = uzcardPlaceHolder.withdrawMoney(withdrawMoneyDto);
                    if(responseDto.getSuccess()) {
                        System.out.println(withdrawMoneyDto.getPrice());
                        checkToPayment++;
                        withdrawMoneyDto.setCardNumberTakeOff(withdrawMoneyDto.getCardNumberAddMoney());
                        withdrawMoneyDto.setCardNumberAddMoney(phoneNumberPaymentDto.getServiceCardNumber());
                        withdrawMoneyDto.setPrice(withdrawMoneyDto.getPrice() / 2);
                        responseDto = uzcardPlaceHolder.withdrawMoney(withdrawMoneyDto);
                        if(responseDto.getSuccess()) {
                            checkToPayment++;
                            System.out.println(withdrawMoneyDto.getPrice());
                        }
                    }
                }
            } else if (withdrawMoneyDto.getCardNumberTakeOff().startsWith("9860")) {
                withdrawMoneyDto.setCardNumberAddMoney(provider.get().getHumoCardNumber());
                responseDto = humoPlaceHolder.withdrawMoney(withdrawMoneyDto);
                if(responseDto.getSuccess()) {
                    System.out.println(withdrawMoneyDto.getPrice());
                    checkToPayment++;
                    withdrawMoneyDto.setCardNumberTakeOff(withdrawMoneyDto.getCardNumberAddMoney());
                    withdrawMoneyDto.setCardNumberAddMoney(humoCardNumberForService);
                    withdrawMoneyDto.setPrice(withdrawMoneyDto.getPrice() * 0.4);
                    responseDto = humoPlaceHolder.withdrawMoney(withdrawMoneyDto);
                    if(responseDto.getSuccess()) {
                        checkToPayment++;
                        System.out.println(withdrawMoneyDto.getPrice());
                        withdrawMoneyDto.setCardNumberTakeOff(withdrawMoneyDto.getCardNumberAddMoney());
                        withdrawMoneyDto.setCardNumberAddMoney(humoCardNumberForService);
                        withdrawMoneyDto.setPrice(withdrawMoneyDto.getPrice() / 2);
                        responseDto = humoPlaceHolder.withdrawMoney(withdrawMoneyDto);
                        if(responseDto.getSuccess()) {
                            checkToPayment++;
                            System.out.println(withdrawMoneyDto.getPrice());
                        }
                    }
                }
            }
        }
        if(checkToPayment != 3 && checkToPayment != 0) {
            if(phoneNumberPaymentDto.getCardNumber().startsWith("8600")) {
                ResponseDto<Void> responseDto =  uzcardPlaceHolder.rollBack(transActionId);
            } else {
                ResponseDto<Void> responseDto =  humoPlaceHolder.rollBack(transActionId);
            }
            if(phoneNumberPaymentDto.getProviderName().equals("beeline")) {
                ResponseDto<Void> responseDto =  beelinePlaceHolder.rollBack(transActionId);
            } else if (phoneNumberPaymentDto.getProviderName().equals("ucell")) {
                ResponseDto<Void> responseDto =  ucellPlaceHolder.rollBack(transActionId);
            } else if (phoneNumberPaymentDto.getProviderName().equals("mobiuz")) {
                ResponseDto<Void> responseDto =  mobiUzPlaceHolder.rollBack(transActionId);
            } else if (phoneNumberPaymentDto.getProviderName().equals("perfectum")) {
                ResponseDto<Void> responseDto =  perfectumPlaceHolder.rollBack(transActionId);
            } else if (phoneNumberPaymentDto.getProviderName().equals("uzmobile")) {
                ResponseDto<Void> responseDto =  uzMobilePlaceHolder.rollBack(transActionId);
            }
        }

    }
}
