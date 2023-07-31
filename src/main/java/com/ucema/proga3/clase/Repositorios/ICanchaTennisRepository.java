package com.ucema.proga3.clase.Repositorios;

import com.ucema.proga3.clase.Model.CanchaTennis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICanchaTennisRepository extends CrudRepository<CanchaTennis,Long> {
    //CanchaTennis SaveCanchaTennis(CanchaTennis cTennis);
    public List<CanchaTennis> findAll();
}
