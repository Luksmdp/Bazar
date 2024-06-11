package com.tpintegrador.bazar.repository;

import com.tpintegrador.bazar.model.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaDetalleRepository extends JpaRepository<VentaDetalle,Long> {
}
