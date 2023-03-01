package com.uob.service;

import com.uob.model.Slot;

import java.util.List;

public interface SlotService {

    List<Slot> getAllSlots();

    Slot getSlotById(long id);

    Slot getSlotsBySize(String size);

    Slot addSlot(Slot slot);

    Slot updateSlot(Slot slot);

    Slot deleteSlot(long id);




}
