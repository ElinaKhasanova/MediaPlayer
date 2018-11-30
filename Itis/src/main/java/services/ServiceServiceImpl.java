package services;

import entities.Service;
import repozitories.ServiceRepoImpl;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {

    private ServiceRepoImpl serviceRepo;

    public ServiceServiceImpl(ServiceRepoImpl serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepo.findAll();
    }
}
