package com.michote.dao;

import com.michote.entity.HouseImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jtq603 on 10/16/16.
 */

@Repository
public interface ImageDao extends CrudRepository<HouseImage, Long> {

    /**
     * Return the user having the passed imageId or null if no image is found.
     *
     * @param imageId the image imageId.
     */
    public HouseImage findByImageId(long imageId);
}
