package com.dinet.documents.service;

import com.dinet.documents.web.model.InventoryModel;

public interface IInventoryService {

	InventoryModel create(InventoryModel inventoryModel) throws Exception;
}
