package com.uob.service;

import com.uob.exception.ResourceNotFoundException;
import com.uob.model.Item;
import com.uob.model.Slot;
import com.uob.repository.ItemRepository;
import com.uob.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SlotServiceImpl implements SlotService {

    @Autowired
    private SlotRepository slotRepository;
    private ItemRepository itemRepository;

    @Override
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @Override
    public Slot getSlotById(long id) {
        Optional<Slot> slot = slotRepository.findById(id);
        if(slot.isPresent()) {
            return slot.get();
        } else {
            throw new ResourceNotFoundException("Slot not found with id: " + id);
        }
    }

    @Override
    public Slot getSlotsBySize(String size) {
        Optional<Slot> slot = slotRepository.findBySize(size);
        if(slot.isPresent()) {
            return slot.get();
        } else {
            throw new ResourceNotFoundException("Slot not found with size: " + size);
        }
    }

    @Override
    public Slot addSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public Slot updateSlot(Slot slot) {
        Optional<Slot> slot_db = this.slotRepository.findById(slot.getId());
        if(slot_db.isPresent()){
            Slot slotUpdate = slot_db.get();
            slotUpdate.setId(slot.getId());
            slotUpdate.setSize(slot.getSize());
            slotRepository.save(slotUpdate);
            return slotUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + slot.getId());
        }
    }

    @Override
    public Slot deleteSlot(long id) {
        Optional<Slot> slot_db = this.slotRepository.findById(id);
        if(slot_db.isPresent()){
            this.slotRepository.delete(slot_db.get());
            return slot_db.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }


}