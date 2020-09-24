package com.studywara.zone;/*
 * @created 24/09/2020 - 7:37 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone,Long> {
}
