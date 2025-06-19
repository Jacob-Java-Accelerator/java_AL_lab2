package com.roczyno;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OderServiceImpl implements OrderService{
	private final OrderRepository orderRepository;

	@Override
	public String saveOrder(Order order) {
		orderRepository.save(order);
		return "saved";
	}
}
