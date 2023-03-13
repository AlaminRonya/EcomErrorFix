//package com.attrabit.ecom.service;
//
//import com.attrabit.ecom.dto.response.ResponseCouponsDTO;
//import com.attrabit.ecom.exception.ResourceNotFoundException;
//import com.attrabit.ecom.model.Coupons;
//import com.attrabit.ecom.repository.CouponsRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class CouponsService {
//
//    @Autowired
//    private CouponsRepository couponsRepository;
//
//    public List<ResponseCouponsDTO> getAllCoupons() {
//        List<Coupons> coupons = couponsRepository.findAll();
//        return coupons.stream()
//                .map(this::convertToResponseDTO)
//                .collect(Collectors.toList());
//    }
//
//    public ResponseCouponsDTO getCouponById(Long id) throws ResourceNotFoundException {
//        Coupons coupons = couponsRepository.findById(id).orElseThrow(() ->
//                new ResourceNotFoundException("Coupon", "id", id));
//        return convertToResponseDTO(coupons);
//    }
//
//    public ResponseCouponsDTO createCoupon(Coupons requestDTO) {
//        Coupons coupons = convertToEntity(requestDTO);
//        coupons = couponsRepository.save(coupons);
//        return convertToResponseDTO(coupons);
//    }
//
////    public ResponseCouponsDTO updateCouponByID(Long id, Coupons requestDTO) throws ResourceNotFoundException {
////        Coupons coupons = couponsRepository.findById(id).orElseThrow(() ->
////                new ResourceNotFoundException("Coupon", "id", id));
////        coupons.setCode(requestDTO.getCode());
////        coupons.setValue(requestDTO.getValue());
////        coupons.setIsPercent(requestDTO.getIsPercent());
////        coupons.setFreeShipping(requestDTO.getFreeShipping());
////        coupons.setMinimumSpend(requestDTO.getMinimumSpend());
////        coupons.setMaximumSpend(requestDTO.getMaximumSpend());
////        coupons.setUsageLimitPerCoupon(requestDTO.getUsageLimitPerCoupon());
////        coupons.setUsageLimitPerCustomer(requestDTO.getUsageLimitPerCustomer());
////        coupons.setIsActive(requestDTO.getIsActive());
////        coupons.setStartDate(requestDTO.getStartDate());
////        coupons.setEndDate(requestDTO.getEndDate());
////        coupons = couponsRepository.save(coupons);
////        return convertToResponseDTO(coupons);
////    }
//
//
//    public void deleteCouponByID(Long id) throws ResourceNotFoundException {
//        Coupons coupons = couponsRepository.findById(id).orElseThrow(() ->
//                new ResourceNotFoundException("Coupon", "id", id));
//        couponsRepository.delete(coupons);
//    }
//
//    private ResponseCouponsDTO convertToResponseDTO(Coupons coupons) {
//        ModelMapper mapper = new ModelMapper();
//        return mapper.map(coupons, ResponseCouponsDTO.class);
//    }
//
//    private Coupons convertToEntity(Coupons requestDTO) {
//        ModelMapper mapper = new ModelMapper();
//        return mapper.map(requestDTO, Coupons.class);
//    }
//}

package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestCouponsDTO;
import com.attrabit.ecom.dto.response.ResponseCouponsDTO;
import com.attrabit.ecom.exception.ResourceNotFoundException;
import com.attrabit.ecom.model.Coupons;
import com.attrabit.ecom.repository.CouponsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponsService {

    @Autowired
    private CouponsRepository couponsRepository;

    public List<ResponseCouponsDTO> getAllCoupons() {
        List<Coupons> couponsList = couponsRepository.findAll();
        return couponsList.stream()
                .map(coupon -> convertToResponseDTO(coupon))
                .collect(Collectors.toList());
    }

    public ResponseCouponsDTO getCouponByID(Long id) throws ResourceNotFoundException {
        Coupons coupons = couponsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Coupon"));
        return convertToResponseDTO(coupons);
    }

    public ResponseCouponsDTO createCoupon(RequestCouponsDTO requestDTO) {
        Coupons coupons = new Coupons();
        BeanUtils.copyProperties(requestDTO, coupons);
        coupons = couponsRepository.save(coupons);
        return convertToResponseDTO(coupons);
    }

    public ResponseCouponsDTO updateCouponByID(Long id, RequestCouponsDTO requestDTO) throws ResourceNotFoundException {
        Coupons coupons = couponsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Coupon"));
        BeanUtils.copyProperties(requestDTO, coupons);
        coupons = couponsRepository.save(coupons);
        return convertToResponseDTO(coupons);
    }

    public void deleteCouponByID(Long id) throws ResourceNotFoundException {
        Coupons coupons = couponsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Coupon"));
        couponsRepository.delete(coupons);
    }

    private ResponseCouponsDTO convertToResponseDTO(Coupons coupons) {
        ResponseCouponsDTO responseDTO = new ResponseCouponsDTO();
        BeanUtils.copyProperties(coupons, responseDTO);
        return responseDTO;
    }
}

