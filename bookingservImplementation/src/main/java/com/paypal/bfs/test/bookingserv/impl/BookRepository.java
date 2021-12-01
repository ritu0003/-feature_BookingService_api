package com.paypal.bfs.test.bookingserv.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

public interface BookRepository extends JpaRepository<Booking, Long> {

}
