package com.roczyno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OrderServiceTest {
	@Mock
	private OrderRepository orderRepository;

	@InjectMocks
	private OrderService orderService;

	@BeforeEach
	void setUp() {
	}

	@Test
	public void testSaveOrder_ShouldReturnTrue_WhenOrderIsSavedSuccessfully() {

		Order order = new Order(1L,"Margherita", "Large");
		String returnString="saved";

		when(orderRepository.save(order)).thenReturn(Optional.of(returnString));

		String result = orderService.saveOrder(order);

		verify(orderRepository).save(order);
		assertEquals(returnString,result);

	}

	@Test
	public void testSaveOrder_ShouldReturnFalse_WhenOrderSaveFails() {
		Order order = new Order("Pepperoni", "Medium");

		when(orderRepository.save(order)).thenReturn(false);

		boolean result = orderService.saveOrder(order);

		verify(orderRepository).save(order);
		assertFalse(result);
	}
}
