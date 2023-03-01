package com.uob.controller;

import com.uob.model.Slot;
import com.uob.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class SlotController {

    @Autowired
    private SlotService slotService;

    @GetMapping("/slots")
    public ResponseEntity <List<Slot>> getAllSlots(){
        return ResponseEntity.ok().body(slotService.getAllSlots());
    }

    @GetMapping("/slots/{id}")
    public ResponseEntity <Slot> getSlotById(@PathVariable long id){
        return ResponseEntity.ok().body(slotService.getSlotById(id));
    }

    @GetMapping("/slots/size/{size}")
    public ResponseEntity <Slot> getSlotsBySize(@PathVariable String size){
        return ResponseEntity.ok().body(slotService.getSlotsBySize(size));
    }

    @PutMapping("/slots/{id}")
    public ResponseEntity <Slot> updateSlot(@PathVariable long id, @RequestBody Slot slot){
        slot.setId(id);
        return ResponseEntity.ok().body(slotService.updateSlot(slot));
    }

    @PostMapping("/slots")
    public ResponseEntity <Slot> addSlot(@RequestBody Slot slot){
        return ResponseEntity.ok().body(slotService.addSlot(slot));
    }

    @DeleteMapping("/slots/{id}")
    public ResponseEntity <Slot> deleteSlot(@PathVariable long id) {
        return ResponseEntity.ok().body(slotService.deleteSlot(id));
    }

}
