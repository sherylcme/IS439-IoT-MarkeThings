package is439.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import is439.edu.model.Voucher;
import is439.edu.repositories.VoucherRepository;

@CrossOrigin(origins = "*", maxAge= 3600)
@RestController
@RequestMapping("/voucher") // any request to the host starting with pets will redirect here
public class VoucherController {
    @Autowired // creates an instance
    private VoucherRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Voucher> getAllVouchers() {
        return repository.findAll();
    }

    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Voucher createVoucher(@Valid @RequestBody Voucher voucher) {
        voucher.set_id(ObjectId.get());
        repository.save(voucher);
        return voucher;
    }

   
}