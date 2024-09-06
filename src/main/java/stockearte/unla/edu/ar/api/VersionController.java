package stockearte.unla.edu.ar.api;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import stockearte.unla.edu.ar.dev.Version;

@Controller
public class VersionController {

	@GetMapping("/version")
	public @ResponseBody String version() {
		return Version.ACTUAL.longDescription();
	}
	
	@GetMapping("/allVersions")
	public @ResponseBody String allVersions() throws JsonProcessingException {
		Collection<String> versions = new ArrayList<>();
		for(Version version : Version.values()) versions.add(version.longDescription());
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(versions);
	}
}