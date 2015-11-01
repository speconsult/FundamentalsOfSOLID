package solid.fundamentals.claimhandling.customerClaim.control;

import solid.fundamentals.claimhandling.customerClaim.entity.CustomerClaim;
import solid.fundamentals.claimhandling.customerClaim.entity.CustomerClaimFactory;

import java.util.Date;

/**
 * Created by zapp on 01/11/15.
 */
public class CreateAutoCustomerClaim extends CustomerClaimUseCase {


    public CustomerClaim execute(
            String name,
            String insuredCarsLicensePlate,
            String counterpartsLicensePlate
    ) {

        CustomerClaim  autoClaim = CustomerClaimFactory.createAutoClaim(
                new Date(),
                new Date(),
                name,
                insuredCarsLicensePlate,
                counterpartsLicensePlate);

        String id = persistence.createClaim(autoClaim);
        autoClaim.setId(id);

        return autoClaim;
    }
}