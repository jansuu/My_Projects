package com.hotelbooking.cozyheaven.service;

import com.hotelbooking.cozyheaven.enums.ApprovalStatus;

import com.hotelbooking.cozyheaven.enums.IsVerified;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.VerificationRequest;
import com.hotelbooking.cozyheaven.repository.VerificationRequestRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VerificationRequestServiceTest {

    @InjectMocks
    private VerificationRequestService verificationRequestService;

    @Mock
    private VerificationRequestRepository verificationRequestRepository;

    @Mock
    private HotelOwnerService hotelOwnerService;

    @Mock
    private HotelService hotelService;

    VerificationRequest request;
    HotelOwner owner;
    Hotel hotel;

    @BeforeEach
    public void init() {
        owner = new HotelOwner();
        owner.setId(1);
        owner.setName("Owner One");
        owner.setIsVerified(IsVerified.Verified);

        hotel = new Hotel();
        hotel.setId(1);
        hotel.setName("Sun Hotel");
        hotel.setHotelOwner(owner);

        request = new VerificationRequest();
        request.setId(1);
        request.setHotelOwner(owner);
        request.setHotel(hotel);
        request.setStatus(ApprovalStatus.PENDING);
    }

    @Test
    public void testAddVerificationRequest() throws InvalidIDException {
        when(hotelService.findByHotelID(1)).thenReturn(hotel);
        when(hotelOwnerService.getOwnerByID(1)).thenReturn(owner);
        when(verificationRequestRepository.save(any(VerificationRequest.class))).thenReturn(request);

        VerificationRequest saved = verificationRequestService.addVerificationRequest(1, request);
        assertEquals(ApprovalStatus.PENDING, saved.getStatus());
    }

    @Test
    public void testAcceptRequest() throws InvalidIDException {
        when(verificationRequestRepository.findById(1)).thenReturn(Optional.of(request));
        when(hotelOwnerService.getOwnerByID(1)).thenReturn(owner);
        when(verificationRequestRepository.save(any(VerificationRequest.class))).thenReturn(request);

        VerificationRequest updated = verificationRequestService.acceptRequest(1);
        assertEquals(ApprovalStatus.APPROVED, updated.getStatus());
    }

    @Test
    public void testCancelRequest() throws InvalidIDException {
        when(verificationRequestRepository.findById(1)).thenReturn(Optional.of(request));
        when(hotelOwnerService.getOwnerByID(1)).thenReturn(owner);
        when(verificationRequestRepository.save(any(VerificationRequest.class))).thenReturn(request);

        VerificationRequest cancelled = verificationRequestService.cancelRequest(1);
        assertEquals(ApprovalStatus.CANCELLED, cancelled.getStatus());
    }

    @Test
    public void testGetById_Valid() throws InvalidIDException {
        when(verificationRequestRepository.findById(1)).thenReturn(Optional.of(request));
        VerificationRequest found = verificationRequestService.getRequestById(1);
        assertEquals(1, found.getId());
    }

    @Test
    public void testGetById_Invalid() {
        when(verificationRequestRepository.findById(2)).thenReturn(Optional.empty());
        assertThrows(InvalidIDException.class, () -> verificationRequestService.getRequestById(2));
    }

    @Test
    public void testGetPendingRequests() {
        List<VerificationRequest> mockList = Arrays.asList(request);
        when(verificationRequestRepository.findByStatus(ApprovalStatus.PENDING)).thenReturn(mockList);

        List<VerificationRequest> result = verificationRequestService.getPendingRequests();
        assertEquals(1, result.size());
        assertEquals(ApprovalStatus.PENDING, result.get(0).getStatus());
    }

    @Test
    public void testGetRequestByHotel() throws InvalidIDException {
        when(hotelService.findByHotelID(1)).thenReturn(hotel);
        when(verificationRequestRepository.findByHotelId(1)).thenReturn(request);

        VerificationRequest found = verificationRequestService.getRequestByHotel(1);
        assertEquals(hotel.getId(), found.getHotel().getId());
    }

    @Test
    public void testGetRequestByOwnerId() throws InvalidIDException {
        when(hotelOwnerService.getOwnerByID(1)).thenReturn(owner);
        when(verificationRequestRepository.findByHotelOwnerId(1)).thenReturn(request);

        VerificationRequest found = verificationRequestService.getRequestsByOwnerId(1);
        assertEquals(owner.getId(), found.getHotelOwner().getId());
    }

    @Test
    public void testGetAllRequests() {
        List<VerificationRequest> list = Arrays.asList(request);
        when(verificationRequestRepository.findAll()).thenReturn(list);

        List<VerificationRequest> all = verificationRequestService.getAll();
        assertEquals(1, all.size());
    }
}
