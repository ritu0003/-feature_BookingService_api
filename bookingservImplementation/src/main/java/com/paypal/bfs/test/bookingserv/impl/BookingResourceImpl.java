package com.paypal.bfs.test.bookingserv.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;

@RestController
public class BookingResourceImpl implements BookingResource {

	
    private BookRepository bookRepository;
	
    @Override
    public ResponseEntity<Booking> create(Booking booking) {
         if (booking.getId() != null) {
             return ResponseEntity.badRequest().body(null);
         }
         Booking result = bookRepository.save(booking);
         try {
			return ResponseEntity.created(new URI("/v1/bfs/booking" + result.getId()))
			     .body(result);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(result);
    }
    
	@Override
	public List<Booking> getAll(Booking booking) {
	        List<Booking> bookings = bookRepository.findAll();
	        return bookings;
	}
}
