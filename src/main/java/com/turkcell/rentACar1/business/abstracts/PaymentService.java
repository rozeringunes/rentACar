package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.payments.*;
import com.turkcell.rentACar1.business.dtos.requests.rentals.UpdateRentalRequest;
import com.turkcell.rentACar1.business.dtos.responses.payments.*;

import java.util.List;

public interface PaymentService {
  CreatedPaymentResponse add(CreatePaymentRequest createPaymentRequest);
  void addPendingPayment(CreatePendingPaymentRequest createPendingPaymentRequest);
  UpdatedPaymentResponse update(int id, UpdatePaymentRequest updatePaymentRequest);
  void delete(int id);
  List<GetAllPaymentsListItemDto>getAll();
  List<GetAllPaymentsByRentalListItemDto>getAllByRental(int rentalId);
  GetPaymentResponse get (int id);
  void completeWithCar(CompletePaymentWithCarRequest completePaymentWithCarRequest);
  void complete (CompletePaymentRequest completePaymentRequest);


}
