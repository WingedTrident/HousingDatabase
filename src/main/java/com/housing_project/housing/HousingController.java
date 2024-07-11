package com.housing_project.housing;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class HousingController {

    private final HouseRepository houseRepository;

    public HousingController(final HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @GetMapping("/home")
    public Iterable<House> getAllHouses() {
        return this.houseRepository.findAll();
    }

    @GetMapping("/home/{id}")
    public Optional<House> getMethodName(@PathVariable("id") Integer id) {
        return this.houseRepository.findById(id);
    }

    @PostMapping("/home")
    public House createNewHouse(@RequestBody House house) {
        House newHouse = this.houseRepository.save(house);
        return newHouse;
    }

    @PutMapping("/home/{id}")
    public House putMethodName(@PathVariable Integer id, @RequestBody House h) {
        Optional<House> houseToFind = this.houseRepository.findById(id);
        if (!houseToFind.isPresent()){
            return null;
        }

        House houseToUpdate = houseToFind.get();

        if (h.getAddress() != null){ houseToUpdate.setAddress(h.getAddress()); }

        if (h.getPrice() != null){ houseToUpdate.setPrice(h.getPrice()); }

        if (h.getSize() != null){ houseToUpdate.setSize(h.getSize()); }

        if (h.getRooms() != null){ houseToUpdate.setRooms(h.getRooms()); }

        if (h.getIsSold() != null){ houseToUpdate.setIsSold(h.getIsSold()); }

        House updatedHouse = this.houseRepository.save(houseToUpdate);
        return updatedHouse;
    }

    @DeleteMapping("/home/{id}")
    public House deleteHouse(@PathVariable("id") Integer id){
        Optional<House> houseToDelete = this.houseRepository.findById(id);
        if (!houseToDelete.isPresent()){
            return null;
        }

        House deletedHouse = houseToDelete.get();
        this.houseRepository.delete(deletedHouse);
        return deletedHouse;
    }

    @GetMapping("/home/sold")
    public List<House> checkSold(@RequestParam(name="sold", required=false) Boolean sold){
        if (sold){
            return this.houseRepository.findByIsSoldTrue();
        } else {
            return new ArrayList<>();
        }
    }
}
