package com.michote.controller;


import com.michote.dao.SampleUserDao;
import com.michote.entity.SampleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jtq603 on 10/15/16.
 */
@Controller
public class UserController {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * /create  --> Create a new user and save it in the database.
     *
     * @param email SampleUser's email
     * @param name SampleUser's name
     * @return A string describing if the user is succesfully created or not.
     */
	@RequestMapping(value = "/create/{email}/{name}")
	@ResponseBody
	public String create(@PathVariable String email, @PathVariable String name) {
		SampleUser user = null;
		try {
			user = new SampleUser(email, name);
			userDao.save(user);
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "SampleUser succesfully created! (id = " + user.getId() + ")";
	}

	/**
	 * /delete --> Delete the user having the passed id.
	 *
	 * @param id
	 *            The id of the user to delete
	 * @return A string describing if the user is succesfully deleted or not.
	 */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            SampleUser user = new SampleUser(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "SampleUser succesfully deleted!";
    }

    /**
     * /get-by-email  --> Return the id for the user having the passed email.
     *
     * @param email The email to search in the database.
     * @return The user id or a message error if the user is not found.
     */
    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            SampleUser user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "SampleUser not found";
        }
        return "The user id is: " + userId;
    }
    /**
     * /get-by-name  --> Return the id for the user having the passed name.
     *
     * @param name The email to search in the database.
     * @return The user id or a message error if the user is not found.
     */
    @RequestMapping("/get-by-name")
    @ResponseBody
    public String getByName(String name) {
        String userId;
        try {
            SampleUser user = userDao.findByName(name);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "SampleUser not found";
        }
        return "The user id is: " + userId;
    }
    /**
     * /update  --> Update the email and the name for the user in the database
     * having the passed id.
     *
     * @param id The id for the user to update.
     * @param email The new email.
     * @param name The new name.
     * @return A string describing if the user is succesfully updated or not.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            SampleUser user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "SampleUser succesfully updated!";
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private SampleUserDao userDao;

} // class UserController
