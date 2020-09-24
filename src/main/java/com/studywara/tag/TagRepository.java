package com.studywara.tag;/*
 * @created 24/09/2020 - 4:21 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface TagRepository extends JpaRepository<Tag,Long> {

//    Optional<Tag> findByTitle(String title);
    Tag findByTitle(String title);
}

