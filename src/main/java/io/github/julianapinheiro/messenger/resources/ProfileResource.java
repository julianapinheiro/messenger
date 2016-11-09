package io.github.julianapinheiro.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.github.julianapinheiro.messenger.model.Profile;
import io.github.julianapinheiro.messenger.service.ProfileService;

@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

ProfileService ProfileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles() {
		return ProfileService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile Profile) {
		return ProfileService.addProfile(Profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return ProfileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		ProfileService.removeProfile(profileName);
	}
	
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return ProfileService.getProfile(profileName);  
	}
	
}
