package personallec04.plec04.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import personallec04.plec04.model.Chamber;
// import personallec04.plec04.model.ChamberMapper;
// import personallec04.plec04.model.ChamberUser;
// import personallec04.plec04.model.UserInfo;

@Controller
@RequestMapping("/sample4")
public class Sample41Controller {

  @GetMapping("step1")
  public String sample41() {
    return "sample41.html";
  }
}
