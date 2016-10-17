package com.michote.dao;

import com.michote.entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jtq603 on 10/16/16.
 */

@Transactional
public interface ImageDao extends CrudRepository<Image, Long> {

    /**
     * Return the user having the passed imageId or null if no image is found.
     *
     * @param imageId the image imageId.
     */
    public Image findByImageId(long imageId);
}
