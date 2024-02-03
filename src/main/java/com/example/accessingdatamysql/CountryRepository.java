package com.example.accessingdatamysql;

import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, BigInteger> {
}
