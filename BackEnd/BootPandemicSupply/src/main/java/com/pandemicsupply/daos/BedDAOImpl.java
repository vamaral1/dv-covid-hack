package com.pandemicsupply.daos;

import com.pandemicsupply.entities.Bed;
import com.pandemicsupply.repositories.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class BedDAOImpl implements BedDAO{

    @Autowired
    private BedRepository bedRepo;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Bed findBedById(int bid) {
        Optional<Bed> facility = bedRepo.findById(bid);
        if (facility.isPresent()) {
            return facility.get();
        } else {
            return null;
        }
    }

    @Override
    public Bed createBed(Bed bed) {
        return bedRepo.saveAndFlush(bed);
    }

    @Override
    public Bed modifyBed(Bed bed) {
        Optional<Bed> optionalBed = bedRepo.findById(bed.getId());

        if (optionalBed.isPresent()) {
            Bed managedBed = optionalBed.get();
            managedBed.setIcu(bed.getIcu());
            managedBed.setType(bed.getType());
            return bedRepo.saveAndFlush(bed);
        }
        return null;
    }
}
