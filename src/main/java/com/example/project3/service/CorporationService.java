package com.example.project3.service;


import com.example.project3.pojo.Corporation;

import java.util.List;

public interface CorporationService {
	void insert (Corporation corporation);

	void delete (Integer corporationId);

	void drop (Integer corporationId);

	Corporation select (Integer corporationId);

	List<Corporation> selectAll ();



	void update (Corporation corporation);

}
