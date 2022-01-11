package com.mindfulqatar.jobportal.web;

import static com.mindfulqatar.jobportal.constants.Constant.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mindfulqatar.jobportal.dto.AccountEditDTO;
import com.mindfulqatar.jobportal.dto.AdvertisementDTO;
import com.mindfulqatar.jobportal.dto.ApplyJobDTO;
import com.mindfulqatar.jobportal.dto.EmployerDTO;
import com.mindfulqatar.jobportal.dto.EmployerEditDTO;
import com.mindfulqatar.jobportal.dto.JobPostDTO;
import com.mindfulqatar.jobportal.dto.JobseekerDTO;
import com.mindfulqatar.jobportal.dto.JobseekerEditDTO;
import com.mindfulqatar.jobportal.dto.PasswordEditDTO;
import com.mindfulqatar.jobportal.dto.SearchAdvertisementsDTO;
import com.mindfulqatar.jobportal.dto.SearchEmployersDTO;
import com.mindfulqatar.jobportal.dto.SearchJobsDTO;
import com.mindfulqatar.jobportal.dto.SearchJobseekerJobMapDTO;
import com.mindfulqatar.jobportal.dto.SearchJobseekersDTO;
import com.mindfulqatar.jobportal.dto.SearchOrdersDTO;
import com.mindfulqatar.jobportal.dto.SearchUsersDTO;
import com.mindfulqatar.jobportal.dto.UserDTO;
import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.Advertisement;
import com.mindfulqatar.jobportal.entities.CompanyIndustry;
import com.mindfulqatar.jobportal.entities.Country;
import com.mindfulqatar.jobportal.entities.Employer;
import com.mindfulqatar.jobportal.entities.EmployerContactUs;
import com.mindfulqatar.jobportal.entities.Job;
import com.mindfulqatar.jobportal.entities.Jobseeker;
import com.mindfulqatar.jobportal.entities.JobseekerJobMap;
import com.mindfulqatar.jobportal.entities.Message;
import com.mindfulqatar.jobportal.entities.Orders;
import com.mindfulqatar.jobportal.entities.Packages;
import com.mindfulqatar.jobportal.entities.VerificationToken;
import com.mindfulqatar.jobportal.entities.WebContactUs;
import com.mindfulqatar.jobportal.enums.OrderStatusEnum;
import com.mindfulqatar.jobportal.mapper.AccountMapper;
import com.mindfulqatar.jobportal.mapper.AdvertisementMapper;
import com.mindfulqatar.jobportal.mapper.EmployerMapper;
import com.mindfulqatar.jobportal.mapper.JobMapper;
import com.mindfulqatar.jobportal.mapper.JobseekerJobMapMapper;
import com.mindfulqatar.jobportal.mapper.JobseekerMapper;
import com.mindfulqatar.jobportal.mapper.OrdersMapper;
import com.mindfulqatar.jobportal.security.CustomUserDetailsService;
import com.mindfulqatar.jobportal.services.JobService;
import com.mindfulqatar.jobportal.services.JobTypeService;
import com.mindfulqatar.jobportal.services.JobseekerJobMapService;
import com.mindfulqatar.jobportal.services.JobseekerService;
import com.mindfulqatar.jobportal.services.AccountService;
import com.mindfulqatar.jobportal.services.AdvertisementService;
import com.mindfulqatar.jobportal.services.CityService;
import com.mindfulqatar.jobportal.services.CompanyIndustryService;
import com.mindfulqatar.jobportal.services.CompanyTypeService;
import com.mindfulqatar.jobportal.services.CountryService;
import com.mindfulqatar.jobportal.services.EmailSenderService;
import com.mindfulqatar.jobportal.services.EmployerContactUsService;
import com.mindfulqatar.jobportal.services.EmployerService;
import com.mindfulqatar.jobportal.services.FileService;
import com.mindfulqatar.jobportal.services.JobLevelService;
import com.mindfulqatar.jobportal.services.JobRoleService;
import com.mindfulqatar.jobportal.services.MessageService;
import com.mindfulqatar.jobportal.services.OrdersService;
import com.mindfulqatar.jobportal.services.PackagesService;
import com.mindfulqatar.jobportal.services.SectorService;
import com.mindfulqatar.jobportal.services.VerificationTokenService;
import com.mindfulqatar.jobportal.services.WebContactUsService;

@Controller
public class StaticPagesController {
	private static final Logger log = LoggerFactory.getLogger(StaticPagesController.class);

	@Autowired
	private MessageService serviceMessage;

	@Autowired
	private JobService serviceJob;

	@Autowired
	private CityService serviceCity;

	@Autowired
	private SectorService serviceSector;

	@Autowired
	private JobRoleService serviceJobRole;

	@Autowired
	private CompanyIndustryService serviceCompanyIndustry;

	@Autowired
	private CompanyTypeService serviceCompanyType;

	@Autowired
	private JobLevelService serviceJobLevel;

	@Autowired
	private JobTypeService serviceJobType;

	@Autowired
	private EmployerService serviceEmployer;

	@Autowired
	private JobseekerService serviceJobseeker;

	@Autowired
	private PackagesService servicePackages;

	@Autowired
	private AccountService serviceAccount;

	@Autowired
	private FileService serviceFile;

	@Autowired
	private AdvertisementService serviceAdvertisement;

	@Autowired
	private CountryService serviceCountry;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JobseekerJobMapService jobseekerJobMapService;

	@Autowired
	private VerificationTokenService serviceVerificationToken;

	@Autowired
	private WebContactUsService serviceWebContactUs;

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	private OrdersService serviceOrders;

	@Autowired
	private EmployerContactUsService serviceEmployerContactUs;

	@ModelAttribute("job")
	public SearchJobsDTO searchJobsDTO() {
		return new SearchJobsDTO();
	}

	@ModelAttribute("employer")
	public SearchEmployersDTO searchEmployersDTO() {
		return new SearchEmployersDTO();
	}

	@ModelAttribute("advertisement")
	public SearchAdvertisementsDTO searchAdvertisementsDTO() {
		return new SearchAdvertisementsDTO();
	}

	@ModelAttribute("jobseeker")
	public SearchJobseekersDTO searchJobseekersDTO() {
		return new SearchJobseekersDTO();
	}

	@ModelAttribute("account")
	public SearchUsersDTO searchUsersDTO() {
		return new SearchUsersDTO();
	}

	@ModelAttribute("userDTO")
	public UserDTO userDTO() {
		return new UserDTO();
	}

	@ModelAttribute("jobseekerDTO")
	public JobseekerDTO jobseekerDTO() {
		return new JobseekerDTO();
	}

	@ModelAttribute("employerDTO")
	public EmployerDTO employerDTO() {
		return new EmployerDTO();
	}

	@ModelAttribute("applyJobDTO")
	public ApplyJobDTO applyJobDTO() {
		return new ApplyJobDTO();
	}

	@ModelAttribute("searchOrdersDTO")
	public SearchOrdersDTO searchOrdersDTO() {
		return new SearchOrdersDTO();
	}

	@ModelAttribute("searchJobseekerJobMapDTO")
	public SearchJobseekerJobMapDTO searchJobseekerJobMapDTO() {
		return new SearchJobseekerJobMapDTO();
	}

	@ModelAttribute("employerContactUs")
	public EmployerContactUs employerContactUs() {
		return new EmployerContactUs();
	}

	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("sectors", serviceSector.getAllSectors());
		model.addAttribute("cities", serviceCity.getAllCities());
		Advertisement addFilter = new Advertisement();
		addFilter.setShow(true);
		model.addAttribute("advertisements", serviceAdvertisement.searchAdvertisements(addFilter));
		model.addAttribute("popularJobs", serviceJob.getTopNPopularJobs(5));
		return "home";
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("msgs", serviceMessage.getAllMessages());
		return "userhome";
	}

	@PostMapping("/messages")
	public String saveMessage(Message message) {
		serviceMessage.saveMessage(message);
		return "redirect:/home";
	}

	@GetMapping("/aboutus")
	public String getAboutUsPage(Model model) {
		return "about_us";
	}

	@GetMapping("/search/advanced")
	public String getAdvancedSearchPage(Model model) {
		model.addAttribute("sectors", serviceSector.getAllSectors());
		model.addAttribute("cities", serviceCity.getAllCities());
		model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
		model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
		model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
		model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
		model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());
		return "advanced_search";
	}

	@GetMapping("/company/reviews")
	public String getCompanyReviews(Model model) {
		return "company_reviews";
	}

	@GetMapping("/contactus")
	public String getContactUsPage(Model model) {
		return "contact_us";
	}

	@GetMapping("/jobs/companies")
	public String jobsByCompaniesPage(Model model) {
		model.addAttribute("companiesWithJobsCount", serviceJob.getJobsWithCompanyAndJobsCount());
		return "jobs_by_companies";
	}

	@GetMapping("/jobs/location")
	public String jobsByLocationPage(Model model) {
		model.addAttribute("locationsWithJobsCount", serviceJob.getJobsWithLocationAndJobsCount());
		model.addAttribute("totalJobsCount", serviceJob.getAllJobsCount());
		return "jobs_by_location";
	}

	@GetMapping("/jobs/role")
	public String jobsByRolePage(Model model) {
		model.addAttribute("jobRolesWithCount", serviceJob.getJobsWithJobRoleAndJobsCount());
		return "jobs_by_role";
	}

	@GetMapping("/jobs/sector")
	public String jobsBySectorPage(Model model, @RequestParam(required = false, name = "cityIds") Long cityIds) {
		model.addAttribute("sectorsWithJobsCountForEachIndustry", serviceJob.getJobsWithSectorAndJobsCount(cityIds));
		model.addAttribute("cities", serviceCity.getAllCities());
		model.addAttribute("cityIds", cityIds);
		return "jobs_by_sector";
	}

	@GetMapping("/salaries")
	public String salariesPage(Model model) {
		model.addAttribute("cities", serviceCity.getAllCities());
		model.addAttribute("avgSalaryForMostPopularJobs", serviceJob.getAvgSalaryForMostPopularJobs());
		model.addAttribute("avgSalaryForCompanies", serviceJob.getAvgSalaryForCompanies());
		model.addAttribute("avgSalaryForJobRoles", serviceJob.getAvgSalaryForJobRoles());
		model.addAttribute("avgSalaryForLocations", serviceJob.getAvgSalaryForLocations());

		return "salaries";
	}

	@GetMapping("/search/jobs")
	public String searchJobsPage(Model model, @ModelAttribute("job") @Valid SearchJobsDTO searchJobsDTO,
			BindingResult result, HttpServletRequest request,
			@RequestParam(name = "displayMessage", required = false) String displayMessage,
			@RequestParam(name = "displayErrorMessage", required = false) String displayErrorMessage) {
		List<Job> searchedJobs = serviceJob.searchJobs(JobMapper.toJob(searchJobsDTO));

		if (searchJobsDTO.getJobTitle() != null && searchJobsDTO.getJobTitle().equals("executive")) {
			model.addAttribute("headerMessage", "Executive Level Jobs in the Gulf and Middle East");
		} else if (searchJobsDTO.getJobTitle() != null && !searchJobsDTO.getJobTitle().isEmpty()
				&& !searchJobsDTO.getJobTitle().equals("null")) {
			model.addAttribute("headerMessage", searchJobsDTO.getJobTitle() + " Jobs in the Gulf and Middle East");
		} else {
			model.addAttribute("headerMessage", "Jobs in the Gulf and Middle East");
		}

		model.addAttribute("locationsWithJobsCountWithTitle",
				serviceJob.getJobsWithLocationAndJobsCountWithTitle(searchJobsDTO.getJobTitle()));
		model.addAttribute("jobRolesWithJobsCountWithTitle",
				serviceJob.getJobsWithJobRoleAndJobsCountWithTitle(searchJobsDTO.getJobTitle()));
		model.addAttribute("companyIndustriesWithJobsCountWithTitle",
				serviceJob.getJobsWithCompanyIndustryAndJobsCountWithTitle(searchJobsDTO.getJobTitle()));
		model.addAttribute("sectorsWithJobsCountWithTitle",
				serviceJob.getJobsWithSectorAndJobsCountWithTitle(searchJobsDTO.getJobTitle()));
		model.addAttribute("companiesWithJobsCountWithTitle",
				serviceJob.getJobsWithCompanyAndJobsCountWithTitle(searchJobsDTO.getJobTitle()));
		model.addAttribute("last1DayJobsCount", serviceJob.getCountForLastXDaysJobs(searchJobsDTO.getJobTitle(), 1));
		model.addAttribute("last7DaysJobsCount", serviceJob.getCountForLastXDaysJobs(searchJobsDTO.getJobTitle(), 7));
		model.addAttribute("last30DaysJobsCount", serviceJob.getCountForLastXDaysJobs(searchJobsDTO.getJobTitle(), 30));
		model.addAttribute("companyTypesWithJobsCountWithTitle",
				serviceJob.getJobsWithCompanyTypeAndJobsCountWithTitle(searchJobsDTO.getJobTitle()));
		model.addAttribute("jobTypesWithJobsCountWithTitle",
				serviceJob.getJobsWithJobTypeAndJobsCountWithTitle(searchJobsDTO.getJobTitle()));
		model.addAttribute("jobLevelsWithJobsCountWithTitle",
				serviceJob.getJobsWithJobLevelAndJobsCountWithTitle(searchJobsDTO.getJobTitle()));
		model.addAttribute("gendersWithJobsCountWithTitle",
				serviceJob.getJobsWithGenderAndJobsCountWithTitle(searchJobsDTO.getJobTitle()));

		model.addAttribute("searchJobsDTO", searchJobsDTO);
		model.addAttribute("searchedJobs", searchedJobs);
		model.addAttribute("lowerLimit", 1);
		model.addAttribute("upperLimit", searchedJobs.size());
		model.addAttribute("displayMessage", displayMessage);
		model.addAttribute("displayErrorMessage", displayErrorMessage);

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceJobseeker.isValidJobseeker(currentLoggedInUser.getId())) {
				Jobseeker currentJobseeker = serviceJobseeker.getJobseekerByEmail(currentLoggedInUser.getEmail());

				List<Long> recentlyAppliedJobIds = jobseekerJobMapService
						.getAllJobIdsByJobseekerId(currentJobseeker.getId());

				model.addAttribute("recentlyAppliedJobIds", recentlyAppliedJobIds);
			}

		} catch (Exception e) {
			model.addAttribute("displayErrorMessage", "Error: Something went wrong. Please try after sometime.");
		}

		return "search_jobs";
	}

	@GetMapping("/search/page")
	public String getSearchPage(Model model) {

		return "search_page";
	}

	@GetMapping("/employer")
	public String getEmployerPage(Model model,
			@RequestParam(name = "displayMessage", required = false) String displayMessage,
			@RequestParam(name = "displayErrorMessage", required = false) String displayErrorMessage) {
		model.addAttribute("packages", servicePackages.getAllPackages());
		model.addAttribute("cities", serviceCity.getAllCities());
		model.addAttribute("displayMessage", displayMessage);
		model.addAttribute("displayErrorMessage", displayErrorMessage);
		return "employer";
	}

	@GetMapping("/employer/home")
	public String getEmployersHomePage(Model model,
			@RequestParam(name = "displayMessage", required = false) String displayMessage,
			@RequestParam(name = "displayErrorMessage", required = false) String displayErrorMessage) {
		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());
				Job filter = new Job();
				filter.setEmployers(Arrays.asList(currentEmployer.getId()));
				List<Job> activeJobs = serviceJob.searchJobs(filter);
				model.addAttribute("activeJobs", activeJobs);
				int applicantsCount = 0;

				for (Job job : activeJobs) {
					applicantsCount = applicantsCount + jobseekerJobMapService.getAllJobsByJobId(job.getId()).size();
				}

				model.addAttribute("applicantsCount", applicantsCount);
				model.addAttribute("cities", serviceCity.getAllCities());
				model.addAttribute("countries", serviceCountry.getAllCountries());
				model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
				model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
				model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));
				model.addAttribute("currentEmployer", currentEmployer);
				model.addAttribute("packages", servicePackages.getAllPackages());
				model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
				model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());
				model.addAttribute("displayMessage", displayMessage);
				model.addAttribute("displayErrorMessage", displayErrorMessage);
				model.addAttribute("allShortListedCandidates", serviceJob.getAllShortlistedCandidates());
				model.addAttribute("allCandidates", serviceJobseeker.getAllJobseekers());

				// Set last login details
				Account currentAccount = currentLoggedInUser;
				currentAccount.setLastLogin(LocalDateTime.now());
				accountService.save(currentAccount);
			}
		} catch (Exception e) {
			model.addAttribute("displayErrorMessage", "Error: Something went wrong. Please try after sometime.");
		}
		return "employers_home";
	}

	@GetMapping("/jobseeker/home")
	public String getJobseekersHomePage(Model model,
			@RequestParam(name = "displayMessage", required = false) String displayMessage,
			@RequestParam(name = "displayErrorMessage", required = false) String displayErrorMessage) {

		model.addAttribute("sectors", serviceSector.getAllSectors());
		model.addAttribute("cities", serviceCity.getAllCities());
		model.addAttribute("countries", serviceCountry.getAllCountries());
		model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
		model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
		model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
		model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
		model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceJobseeker.isValidJobseeker(currentLoggedInUser.getId())) {
				Jobseeker currentJobseeker = serviceJobseeker.getJobseekerByEmail(currentLoggedInUser.getEmail());

				List<JobseekerJobMap> recentlyAppliedJobs = jobseekerJobMapService
						.getAllJobsByJobseekerId(currentJobseeker.getId());

				model.addAttribute("appliedJobsCount", recentlyAppliedJobs.size());
				model.addAttribute("recentlyAppliedJobs", recentlyAppliedJobs);
				Job searchJob = new Job();
				searchJob.setJobTitle(currentJobseeker.getJobTitle());
				List<Job> recommendedJobs = serviceJob.searchJobs(searchJob);
				model.addAttribute("recommendedJobs", recommendedJobs);
				model.addAttribute("jobseekerImagePath", currentJobseeker.getImagePath());
				model.addAttribute("jobseekerResumePath", currentJobseeker.getResumePath());
				model.addAttribute("currentJobseeker", currentJobseeker);
				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));

				// Set last login details
				Account currentAccount = currentLoggedInUser;
				currentAccount.setLastLogin(LocalDateTime.now());
				accountService.save(currentAccount);
			}
		} catch (Exception e) {
			model.addAttribute("displayErrorMessage", "Error: Something went wrong. Please try after sometime.");
		}

		model.addAttribute("displayMessage", displayMessage);
		model.addAttribute("displayErrorMessage", displayErrorMessage);

		return "jobseeker_home";
	}

	@GetMapping("/employer/cvsearch")
	public String getCvSearchPage(Model model) {
		return "cv_search";
	}

	@GetMapping("/employers/contact")
	public String getEmployersContactPage(Model model) {
		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());

				model.addAttribute("currentEmployer", currentEmployer);
				model.addAttribute("countries", serviceCountry.getAllCountries());
			}
		} catch (Exception e) {
			model.addAttribute("displayErrorMessage", "Error: Something went wrong. Please try after sometime.");
		}
		return "employers_contact";
	}

	@GetMapping("/newsfeed")
	public String getNewsFeedPage(Model model) {
		return "news_feed";
	}

	@GetMapping("/find/people")
	public String getFindPeoplePage(Model model) {
		return "find_people";
	}

	@GetMapping("/employer/start/hiring")
	public String getStartHiringPage(Model model) {
		return "start_hiring";
	}

	@GetMapping("/employer/details")
	public String getEmployerDetailsPage(Model model) {
		return "employer_details";
	}

	@GetMapping("/salaries/roles")
	public String getSalariesByRolesPage(Model model) {
		return "salaries_by_roles";
	}

	@GetMapping("/salaries/locations")
	public String getSalariesByLocationPage(Model model) {
		return "salaries_by_location";
	}

	@GetMapping("/admin/home")
	public String getAdminHomePage(Model model,
			@ModelAttribute("employer") @Valid SearchEmployersDTO searchEmployersDTO,
			@ModelAttribute("advertisement") @Valid SearchAdvertisementsDTO searchAdvertisementsDTO,
			@ModelAttribute("jobseeker") @Valid SearchJobseekersDTO searchJobseekersDTO,
			@ModelAttribute("account") @Valid SearchUsersDTO searchUsersDTO,
			@ModelAttribute("job") @Valid SearchJobsDTO searchJobsDTO,
			@ModelAttribute("orders") @Valid SearchOrdersDTO searchOrdersDTO,
			@ModelAttribute("jobseekerJobMap") @Valid SearchJobseekerJobMapDTO searchJobseekerJobMapDTO,
			@RequestParam(required = false, name = "activePageName") String activePageName,
			@RequestParam(required = false, name = "displayErrorMessage") String displayErrorMessage,
			@RequestParam(required = false, name = "displayMessage") String displayMessage) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null) {
				model.addAttribute("registeredEmployersCount", serviceEmployer.countEmployers());
				model.addAttribute("registeredJobseekersCount", serviceJobseeker.countJobseekers());
				model.addAttribute("jobsPostedCount", serviceJob.getAllJobsCount());
				model.addAttribute("jobsAppliedCount", serviceJob.getJobsAppliedCount());
				model.addAttribute("jobseekersAppliedCount", serviceJob.getJobseekersAppliedCount());
				model.addAttribute("sectors", serviceSector.getAllSectors());
				model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
				model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
				model.addAttribute("packages", servicePackages.getAllPackages());
				model.addAttribute("accounts", serviceAccount.getAllAccounts());
				model.addAttribute("advtCount", serviceAdvertisement.countAdvertisements());
				model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());

				model.addAttribute("activePageName", activePageName);
				model.addAttribute("searchEmployersDTO", searchEmployersDTO);
				model.addAttribute("searchAdvertisementsDTO", searchAdvertisementsDTO);
				model.addAttribute("searchJobseekersDTO", searchJobseekersDTO);
				model.addAttribute("searchUsersDTO", searchUsersDTO);
				model.addAttribute("searchJobsDTO", searchJobsDTO);
				model.addAttribute("searchOrdersDTO", searchOrdersDTO);
				model.addAttribute("searchJobseekerJobMapDTO", searchJobseekerJobMapDTO);

				List<Employer> searchedCompanies = serviceEmployer
						.searchEmployers(EmployerMapper.toEmployer(searchEmployersDTO));

				List<Jobseeker> searchedJobseekers = serviceJobseeker
						.searchJobseekers(JobseekerMapper.toJobseeker(searchJobseekersDTO));

				List<Advertisement> searchedAdvertisements = serviceAdvertisement
						.searchAdvertisements(AdvertisementMapper.toAdvertisement(searchAdvertisementsDTO));

				List<Account> searchedUsers = serviceAccount.searchAccounts(AccountMapper.toAccount(searchUsersDTO));

				List<Job> searchedJobs = serviceJob.searchJobs(JobMapper.toJob(searchJobsDTO));

				List<Orders> searchedOrders = serviceOrders.searchOrders(OrdersMapper.toOrder(searchOrdersDTO));

				List<JobseekerJobMap> searchedJobseekerJobMap = jobseekerJobMapService
						.searchJobseekerJobMap(JobseekerJobMapMapper.toJobseekerJobMap(searchJobseekerJobMapDTO));

				// Calculate Orders Revenue
				Long ordersRevenue = searchedOrders.stream().map(x -> x.getAmount()).reduce(0L, Long::sum);

				model.addAttribute("shortlistedCandidateIds", serviceJob.getAllShortlistedCandidatesIds());

				model.addAttribute("searchedJobseekerJobMap", searchedJobseekerJobMap);
				model.addAttribute("searchedJobs", searchedJobs);
				model.addAttribute("searchedCompanies", searchedCompanies);
				model.addAttribute("searchedJobseekers", searchedJobseekers);
				model.addAttribute("searchedAdvertisements", searchedAdvertisements);
				model.addAttribute("searchedUsers", searchedUsers);
				model.addAttribute("searchedOrders", searchedOrders);
				model.addAttribute("countries", serviceCountry.getAllCountries());
				model.addAttribute("cities", serviceCity.getAllCities());
				model.addAttribute("displayErrorMessage", displayErrorMessage);
				model.addAttribute("displayMessage", displayMessage);

				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));
				model.addAttribute("advertisementRevenue", serviceAdvertisement.getAdvertisementRevenue());
				model.addAttribute("employersRevenue", serviceOrders.getEmployersRevenue());
				model.addAttribute("allEmployers", serviceEmployer.searchEmployers(new Employer()));
				model.addAttribute("orderStatuses", OrderStatusEnum.getValues());
				model.addAttribute("ordersRevenue", ordersRevenue);
				model.addAttribute("allJobs", serviceJob.searchJobs(new Job()));
				model.addAttribute("allJobseekers", serviceJobseeker.searchJobseekers(new Jobseeker()));

				// Set last login details
				Account currentAccount = currentLoggedInUser;
				currentAccount.setLastLogin(LocalDateTime.now());
				accountService.save(currentAccount);
			}
		} catch (Exception e) {
			return "admin_home";
		}

		return "admin_home";
	}

	@PostMapping("/admin/employer")
	public String saveEmployer(Model model, @RequestParam("imageFile") MultipartFile imageFile,
			@ModelAttribute("employerDTO") @Valid EmployerDTO employerDTO,
			@RequestParam(required = false, name = "activePageName") String activePageName) {

		if (!imageFile.isEmpty()) {
			serviceFile.writeFile(imageFile, IMAGES_ROOT_FOLDER_PATH + COMPANY_IMAGES_ROOT_FOLDER_PATH
					+ "company_image_" + employerDTO.getAccountId().toString() + ".png");
		}

		// Get the sector here based on Industry
		CompanyIndustry ci = serviceCompanyIndustry.getCompanyIndustryById(employerDTO.getCompanyIndustry());
		if (ci != null) {
			serviceEmployer.save(EmployerMapper.toEmployer(employerDTO, ci.getSectorId()));
		} else {
			serviceEmployer.save(EmployerMapper.toEmployer(employerDTO, null));
		}

		return "redirect:/admin/home?activePageName=employers";
	}

	@PostMapping("/admin/advertisement")
	public String saveAdvertisement(Model model, @RequestParam("imageFile") MultipartFile imageFile,
			@ModelAttribute("advertisementDTO") @Valid AdvertisementDTO advertisementDTO,
			@RequestParam(required = false, name = "activePageName") String activePageName) {

		Advertisement add = serviceAdvertisement.save(AdvertisementMapper.toAdvertisement(advertisementDTO));

		if (!imageFile.isEmpty()) {
			if (advertisementDTO.getId() == null) {
				add.setImagePath(IMAGES_ROOT_FOLDER_PATH + ADVERTISEMENT_IMAGES_ROOT_FOLDER_PATH
						+ "advertisement_image_" + add.getId().toString() + ".png");
				serviceAdvertisement.save(add);
				serviceFile.writeFile(imageFile, IMAGES_ROOT_FOLDER_PATH + ADVERTISEMENT_IMAGES_ROOT_FOLDER_PATH
						+ "advertisement_image_" + add.getId().toString() + ".png");
			} else {
				serviceFile.writeFile(imageFile, IMAGES_ROOT_FOLDER_PATH + ADVERTISEMENT_IMAGES_ROOT_FOLDER_PATH
						+ "advertisement_image_" + advertisementDTO.getId().toString() + ".png");
			}

		}

		return "redirect:/admin/home?activePageName=advertisements";
	}

	@PostMapping("/admin/jobseeker")
	public String saveJobseeker(Model model, @RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("resumeFile") MultipartFile resumeFile,
			@ModelAttribute("jobseekerDTO") @Valid JobseekerDTO jobseekerDTO,
			@RequestParam(required = false, name = "activePageName") String activePageName) {

		if (!imageFile.isEmpty()) {
			serviceFile.writeFile(imageFile, IMAGES_ROOT_FOLDER_PATH + JOBSEEKER_IMAGES_ROOT_FOLDER_PATH
					+ "jobseeker_image_" + jobseekerDTO.getAccountId().toString() + ".png");
		}

		if (!resumeFile.isEmpty()) {
			try {
				String fileAbsolutePath = RESUMES_ROOT_FOLDER_PATH + "resume_" + jobseekerDTO.getAccountId().toString()
						+ ".pdf";
				String extension = resumeFile.getOriginalFilename()
						.substring(resumeFile.getOriginalFilename().lastIndexOf(".") + 1);
				if (!extension.toLowerCase().equals("pdf") && !extension.toLowerCase().equals("docx")
						&& !extension.toLowerCase().equals("doc")) {
					return "redirect:/admin/home?activePageName=jobseekers&displayErrorMessage=Please select only pdf or word format";
				}

				if (extension.toLowerCase().equals("pdf")) {
					serviceFile.writeFile(resumeFile, fileAbsolutePath);
				} else if (extension.toLowerCase().equals("doc")) {
					serviceFile.writeFile(resumeFile, fileAbsolutePath);
					String output = serviceFile.readDocFile(fileAbsolutePath);
					serviceFile.writePdfFile(output, fileAbsolutePath);
				} else if (extension.toLowerCase().equals("docx")) {
					serviceFile.writeFile(resumeFile, fileAbsolutePath);
					String output = serviceFile.readDocxFile(fileAbsolutePath);
					serviceFile.writePdfFile(output, fileAbsolutePath);
				}
			} catch (Exception e) {
				return "redirect:/admin/home?activePageName=jobseekers&displayErrorMessage=Error: Something went wrong. Please try after sometime.";
			}
		}

		// Get the sector here based on Industry
		CompanyIndustry ci = serviceCompanyIndustry.getCompanyIndustryById(jobseekerDTO.getCompanyIndustry());
		if (ci != null) {
			serviceJobseeker.save(JobseekerMapper.toJobseeker(jobseekerDTO, ci.getSectorId()));
		} else {
			serviceJobseeker.save(JobseekerMapper.toJobseeker(jobseekerDTO, null));
		}

		return "redirect:/admin/home?activePageName=jobseekers";
	}

	@PostMapping("/admin/user")
	public String saveUser(Model model, @ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult result,
			HttpServletRequest request,
			@RequestParam(required = false, name = "activePageName") String activePageName) {

		Account existing = accountService.getAccountByEmail(userDTO.getEmail());

		if ((existing != null && userDTO.getId() == null)
				|| (userDTO.getId() != null && existing != null && existing.getId() != userDTO.getId())) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}

		if (result.hasErrors()) {
			model.addAttribute("countries", serviceCountry.getAllCountries());

			// TODO: write logic to show errors
		}

		userDTO.setUsername(userDTO.getEmail());

		accountService.save(userDTO);

		return "redirect:/admin/home?activePageName=users";
	}

	@GetMapping("/admin/employer/{id}")
	public String deleteEmployer(@PathVariable(name = "id") Long id) {
		serviceEmployer.deleteEmployer(id);

		return "redirect:/admin/home?activePageName=employers";
	}

	@GetMapping("/admin/advertisement/{id}")
	public String deleteAdvertisement(@PathVariable(name = "id") Long id) {
		serviceAdvertisement.deleteAdvertisement(id);

		return "redirect:/admin/home?activePageName=advertisements";
	}

	@GetMapping("/admin/jobseeker/{id}")
	public String deleteJobseeker(@PathVariable(name = "id") Long id) {
		serviceJobseeker.deleteJobseeker(id);

		return "redirect:/admin/home?activePageName=jobseekers";
	}

	@GetMapping("/admin/user/{id}")
	public String deleteUser(@PathVariable(name = "id") Long id) {
		serviceAccount.deleteAccount(id);

		return "redirect:/admin/home?activePageName=users";
	}

	@PostMapping("/jobseeker/job/apply")
	public String applyJob(Model model, @ModelAttribute("applyJobDTO") ApplyJobDTO applyJobDTO, BindingResult result,
			@ModelAttribute("job") @Valid SearchJobsDTO searchJobsDTO) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceJobseeker.isValidJobseeker(currentLoggedInUser.getId())
					&& applyJobDTO.getJobId() != null) {
				Jobseeker currentJobseeker = serviceJobseeker.getJobseekerByEmail(currentLoggedInUser.getEmail());
				JobseekerJobMap jobseekerJobMap = new JobseekerJobMap(new Jobseeker(currentJobseeker.getId()),
						new Job(applyJobDTO.getJobId()));
				jobseekerJobMapService.save(jobseekerJobMap);
			}
		} catch (Exception e) {
			return "redirect:/search/jobs?displayErrorMessage=Error: Something went wrong. Please try after sometime."
					+ "&jobTitle=" + searchJobsDTO.getJobTitle();
		}

		return "redirect:/search/jobs?displayMessage=You have successfully applied for " + applyJobDTO.getAppliedJob()
				+ "&jobTitle=" + searchJobsDTO.getJobTitle();
	}

	@GetMapping("/jobseeker/applied/jobs")
	public String getAppliedJobsPage(Model model) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceJobseeker.isValidJobseeker(currentLoggedInUser.getId())) {
				Jobseeker currentJobseeker = serviceJobseeker.getJobseekerByEmail(currentLoggedInUser.getEmail());
				List<JobseekerJobMap> appliedJobs = jobseekerJobMapService
						.getAllJobsByJobseekerId(currentJobseeker.getId());

				model.addAttribute("appliedJobs", appliedJobs);
				model.addAttribute("lowerLimit", 1);
				model.addAttribute("upperLimit", appliedJobs.size());
				model.addAttribute("headerMessage", "Recent Applications");
				model.addAttribute("sectors", serviceSector.getAllSectors());
				model.addAttribute("cities", serviceCity.getAllCities());
				model.addAttribute("countries", serviceCountry.getAllCountries());
				model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
				model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
				model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
				model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
				model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());
				model.addAttribute("currentJobseeker", currentJobseeker);
				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));
			}
		} catch (Exception e) {
			model.addAttribute("displayErrorMessage", "Error: Something went wrong. Please try after sometime.");
		}

		return "jobs_applied";
	}

	@PostMapping("/jobseeker/update/photo")
	public String updatePhoto(Model model, @RequestParam("imageFile") MultipartFile imageFile) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceJobseeker.isValidJobseeker(currentLoggedInUser.getId())) {
				Jobseeker currentJobseeker = serviceJobseeker.getJobseekerByEmail(currentLoggedInUser.getEmail());
				if (!imageFile.isEmpty()) {
					serviceFile.writeFile(imageFile, IMAGES_ROOT_FOLDER_PATH + JOBSEEKER_IMAGES_ROOT_FOLDER_PATH
							+ "jobseeker_image_" + currentJobseeker.getAccount().getId().toString() + ".png");

					currentJobseeker.setImagePath(IMAGES_ROOT_FOLDER_PATH + JOBSEEKER_IMAGES_ROOT_FOLDER_PATH
							+ "jobseeker_image_" + currentJobseeker.getAccount().getId().toString() + ".png");
					serviceJobseeker.save(currentJobseeker);

					return "redirect:/jobseeker/home?displayMessage=Photo uploaded successfully.";
				} else {
					return "redirect:/jobseeker/home?displayErrorMessage=Please select an image file.";
				}
			}
		} catch (Exception e) {
			return "redirect:/jobseeker/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/jobseeker/home";
	}

	@PostMapping("/jobseeker/update/resume")
	public String updateResume(Model model, @RequestParam("resumeFile") MultipartFile resumeFile) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceJobseeker.isValidJobseeker(currentLoggedInUser.getId())) {
				Jobseeker currentJobseeker = serviceJobseeker.getJobseekerByEmail(currentLoggedInUser.getEmail());
				if (!resumeFile.isEmpty()) {
					String fileAbsolutePath = RESUMES_ROOT_FOLDER_PATH + "resume_"
							+ currentJobseeker.getAccount().getId().toString() + ".pdf";
					String extension = resumeFile.getOriginalFilename()
							.substring(resumeFile.getOriginalFilename().lastIndexOf(".") + 1);

					if (!extension.toLowerCase().equals("pdf") && !extension.toLowerCase().equals("docx")
							&& !extension.toLowerCase().equals("doc")) {
						return "redirect:/jobseeker/home?displayErrorMessage=Please select only pdf or word format";
					}

					if (extension.toLowerCase().equals("pdf")) {
						serviceFile.writeFile(resumeFile, fileAbsolutePath);
					} else if (extension.toLowerCase().equals("doc")) {
						serviceFile.writeFile(resumeFile, fileAbsolutePath);
						String output = serviceFile.readDocFile(fileAbsolutePath);
						serviceFile.writePdfFile(output, fileAbsolutePath);
					} else if (extension.toLowerCase().equals("docx")) {
						serviceFile.writeFile(resumeFile, fileAbsolutePath);
						String output = serviceFile.readDocxFile(fileAbsolutePath);
						serviceFile.writePdfFile(output, fileAbsolutePath);
					}

					currentJobseeker.setResumePath(RESUMES_ROOT_FOLDER_PATH + "resume_"
							+ currentJobseeker.getAccount().getId().toString() + ".pdf");
					serviceJobseeker.save(currentJobseeker);

					return "redirect:/jobseeker/home?displayMessage=CV uploaded successfully.";
				} else {
					return "redirect:/jobseeker/home?displayErrorMessage=Please select a pdf or word file.";
				}
			}
		} catch (Exception e) {
			return "redirect:/jobseeker/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/jobseeker/home";
	}

	@GetMapping("/error/approval-needed")
	public String getApprovalErrorPage() {
		return "redirect:/custom-message?errorMessage=You account have not been approved yet. Please contact admin@mindfulqatar.com !!";
	}

	@GetMapping("/error/verify-email")
	public String getVerifyEmailErrorPage() {
		return "redirect:/custom-message?verifyEmail=true";
	}

	@GetMapping("/email/verify")
	@Transactional
	public String verifyEmail(Model model, @RequestParam("token") String verificationToken) {

		try {
			VerificationToken token = serviceVerificationToken.getByVerificationToken(verificationToken);

			if (token != null) {
				Account account = accountService.getAccountByEmail(token.getAccount().getEmail());
				account.setEnabled(true);
				account = accountService.save(account);

				serviceVerificationToken.deleteBasedOnAccountId(account.getId());

				return "redirect:/custom-message?message=Congratulations " + account.getName()
						+ "! Your account has been activated and email is verified !!";
			}
		} catch (Exception e) {
			return "redirect:/error";
		}

		return "redirect:/custom-message?errorMessage=The link is invalid or broken !!";
	}

	@GetMapping("/email/verification/send")
	public String getVerificationEmailPage(Model model) {
		return "email-verification";
	}

	@PostMapping("/email/verification/send")
	public String sendVerificationEmail(HttpServletRequest request, Model model, @RequestParam("email") String email) {

		try {
			Account account = accountService.getAccountByEmail(email);
			if (account == null) {
//				TODO: show error;
			}
			serviceVerificationToken.authWithHttpServletRequest(request, account);
		} catch (Exception e) {
			log.error(e.getMessage());
			return "redirect:/error";
		}

		return "redirect:/custom-message?message=A verification link has been sent to your email " + email.trim()
				+ ". Please click on the same to verify your account.";
	}

	@GetMapping("/employer/posted/jobs")
	public String getPostedJobsPage(Model model) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());
				List<Job> postedJobs = serviceJob.getJobsByEmployerId(currentEmployer.getId());

				for (Job job : postedJobs) {
					Long jobseekerJobMapsCount = jobseekerJobMapService.countAllJobsByJobId(job.getId());
					job.setJobseekerJobMapsCount(jobseekerJobMapsCount);
				}

				model.addAttribute("postedJobs", postedJobs);
				model.addAttribute("lowerLimit", 1);
				model.addAttribute("upperLimit", postedJobs.size());
				model.addAttribute("headerMessage", "Jobs Posted");
				model.addAttribute("sectors", serviceSector.getAllSectors());
				model.addAttribute("cities", serviceCity.getAllCities());
				model.addAttribute("countries", serviceCountry.getAllCountries());
				model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
				model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
				model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
				model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
				model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());
				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));
				model.addAttribute("currentEmployer", currentEmployer);
				model.addAttribute("packages", servicePackages.getAllPackages());
			}
		} catch (Exception e) {
			model.addAttribute("displayErrorMessage", "Error: Something went wrong. Please try after sometime.");
		}

		return "jobs_posted";
	}

	@GetMapping("/employer/job/jobseekers")
	public String getJobseekersAppliedForJob(HttpServletRequest request, Model model, @RequestParam("jobId") Long jobId,
			@RequestParam("jobTitle") String jobTitle) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();
			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());
				List<JobseekerJobMap> appliedBy = jobseekerJobMapService.getAllJobsByJobId(jobId);
				model.addAttribute("appliedBy", appliedBy);
				model.addAttribute("lowerLimit", 1);
				model.addAttribute("upperLimit", appliedBy.size());
				model.addAttribute("headerMessage", "Jobseekers Applied for " + jobTitle);
				model.addAttribute("jobTitle", jobTitle);
				model.addAttribute("sectors", serviceSector.getAllSectors());
				model.addAttribute("cities", serviceCity.getAllCities());
				model.addAttribute("countries", serviceCountry.getAllCountries());
				model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
				model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
				model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
				model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
				model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());
				model.addAttribute("shortlistedCandidateIds", serviceJob.getAllShortlistedCandidateIds(jobId));
				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));
				model.addAttribute("currentEmployer", currentEmployer);
				model.addAttribute("packages", servicePackages.getAllPackages());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return "redirect:/error";
		}

		return "jobseekers_applied";
	}

	@PostMapping("/employer/jobseeker/shortlist")
	public String shortlistJobseekersForJob(HttpServletRequest request, Model model, @RequestParam("jobId") Long jobId,
			@RequestParam("jobseekerId") Long jobseekerId, @RequestParam("jobTitle") String jobTitle) {

		try {
			JobseekerJobMap jobseekerJobMap = jobseekerJobMapService.getByJobseekerAndJob(new Jobseeker(jobseekerId),
					new Job(jobId));
			if (jobseekerJobMap != null) {
				jobseekerJobMap.setShortlisted(true);
				jobseekerJobMapService.save(jobseekerJobMap);
			}

		} catch (Exception e) {
			log.error(e.getMessage());
			return "redirect:/error";
		}
		return "redirect:/employer/job/jobseekers?jobId=" + jobId + "&jobTitle=" + jobTitle;
	}

	@PostMapping("/jobseeker/update")
	public String updateJobSeeker(Model model, @ModelAttribute("accountEditDTO") @Valid AccountEditDTO accountEditDTO,
			@ModelAttribute("jobseekerEditDTO") @Valid JobseekerEditDTO jobseekerEditDTO) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceJobseeker.isValidJobseeker(currentLoggedInUser.getId())) {
				Jobseeker currentJobseeker = serviceJobseeker.getJobseekerByEmail(currentLoggedInUser.getEmail());
				if (currentJobseeker != null) {

					// Get the sector here based on Industry
					CompanyIndustry ci = serviceCompanyIndustry
							.getCompanyIndustryById(jobseekerEditDTO.getCompanyIndustry());
					if (ci != null) {
						serviceJobseeker.save(
								JobseekerMapper.toJobseeker(currentJobseeker, jobseekerEditDTO, ci.getSectorId()));
					} else {
						serviceJobseeker.save(JobseekerMapper.toJobseeker(currentJobseeker, jobseekerEditDTO, null));
					}
				}
				if (accountEditDTO != null) {
					serviceAccount.save(AccountMapper.toAccount(currentLoggedInUser, accountEditDTO));
				}
				return "redirect:/jobseeker/home?displayMessage=Jobseeker details updated successfully.";
			}
		} catch (Exception e) {
			return "redirect:/jobseeker/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/jobseeker/home";
	}

	@PostMapping("/jobseeker/update/password")
	public String updateJobseekerPassword(Model model,
			@ModelAttribute("passwordEditDTO") @Valid PasswordEditDTO passwordEditDTO) {

		if (passwordEditDTO == null || passwordEditDTO.getNewPassword() == null
				|| passwordEditDTO.getNewConfirmPassword() == null || passwordEditDTO.getNewPassword().isEmpty()
				|| passwordEditDTO.getNewConfirmPassword().isEmpty()) {
			return "redirect:/jobseeker/home?displayErrorMessage=Error: Current Password or New Password cannnot be null.";
		}

		if (!passwordEditDTO.getNewPassword().equals(passwordEditDTO.getNewConfirmPassword())) {
			return "redirect:/jobseeker/home?displayErrorMessage=Error: New Password or Confirm Password are not matching.";
		}

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();
			if (currentLoggedInUser != null) {
				serviceAccount.savePassword(currentLoggedInUser, passwordEditDTO.getNewPassword());
				return "redirect:/jobseeker/home?displayMessage=Password changed successfully.";
			}
		} catch (Exception e) {
			return "redirect:/jobseeker/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/jobseeker/home";
	}

	@PostMapping("/employer/update")
	public String updateEmployer(Model model, @ModelAttribute("accountEditDTO") @Valid AccountEditDTO accountEditDTO,
			@ModelAttribute("employerEditDTO") @Valid EmployerEditDTO employerEditDTO) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());
				if (currentEmployer != null) {

					// Get the sector here based on Industry
					CompanyIndustry ci = serviceCompanyIndustry
							.getCompanyIndustryById(employerEditDTO.getCompanyIndustry());
					if (ci != null) {
						serviceEmployer
								.save(EmployerMapper.toEmployer(currentEmployer, employerEditDTO, ci.getSectorId()));
					} else {
						serviceEmployer.save(EmployerMapper.toEmployer(currentEmployer, employerEditDTO, null));
					}
				}
				if (accountEditDTO != null) {
					serviceAccount.save(AccountMapper.toAccount(currentLoggedInUser, accountEditDTO));
				}
				return "redirect:/employer/home?displayMessage=Employer details updated successfully.";
			}
		} catch (Exception e) {
			return "redirect:/employer/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/employer/home";
	}

	@PostMapping("/employer/update/password")
	public String updateEmployerPassword(Model model,
			@ModelAttribute("passwordEditDTO") @Valid PasswordEditDTO passwordEditDTO) {

		if (passwordEditDTO == null || passwordEditDTO.getNewPassword() == null
				|| passwordEditDTO.getNewConfirmPassword() == null || passwordEditDTO.getNewPassword().isEmpty()
				|| passwordEditDTO.getNewConfirmPassword().isEmpty()) {
			return "redirect:/employer/home?displayErrorMessage=Error: Current Password or New Password cannnot be null.";
		}

		if (!passwordEditDTO.getNewPassword().equals(passwordEditDTO.getNewConfirmPassword())) {
			return "redirect:/employer/home?displayErrorMessage=Error: New Password or Confirm Password are not matching.";
		}

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();
			if (currentLoggedInUser != null) {
				serviceAccount.savePassword(currentLoggedInUser, passwordEditDTO.getNewPassword());
				return "redirect:/employer/home?displayMessage=Password changed successfully.";
			}
		} catch (Exception e) {
			return "redirect:/employer/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/employer/home";
	}

	@PostMapping("/admin/update/password")
	public String updateAdminPassword(Model model,
			@ModelAttribute("passwordEditDTO") @Valid PasswordEditDTO passwordEditDTO) {

		if (passwordEditDTO == null || passwordEditDTO.getNewPassword() == null
				|| passwordEditDTO.getNewConfirmPassword() == null || passwordEditDTO.getNewPassword().isEmpty()
				|| passwordEditDTO.getNewConfirmPassword().isEmpty()) {
			return "redirect:/admin/home?displayErrorMessage=Error: Current Password or New Password cannnot be null.";
		}

		if (!passwordEditDTO.getNewPassword().equals(passwordEditDTO.getNewConfirmPassword())) {
			return "redirect:/admin/home?displayErrorMessage=Error: New Password or Confirm Password are not matching.";
		}

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();
			if (currentLoggedInUser != null) {
				serviceAccount.savePassword(currentLoggedInUser, passwordEditDTO.getNewPassword());
				return "redirect:/admin/home?displayMessage=Password changed successfully.";
			}
		} catch (Exception e) {
			return "redirect:/admin/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/admin/home";
	}

	@PostMapping("/admin/update")
	public String updateAdmin(Model model, @ModelAttribute("accountEditDTO") @Valid AccountEditDTO accountEditDTO) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null) {
				if (accountEditDTO != null) {
					serviceAccount.save(AccountMapper.toAccount(currentLoggedInUser, accountEditDTO));
				}
				return "redirect:/admin/home?displayMessage=Admin details updated successfully.";
			}
		} catch (Exception e) {
			return "redirect:/admin/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/admin/home";
	}

	@PostMapping("/employer/update/photo")
	public String updateEmployerPhoto(Model model, @RequestParam("imageFile") MultipartFile imageFile) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());
				if (!imageFile.isEmpty()) {
					serviceFile.writeFile(imageFile, IMAGES_ROOT_FOLDER_PATH + COMPANY_IMAGES_ROOT_FOLDER_PATH
							+ "company_image_" + currentEmployer.getAccount().getId().toString() + ".png");

					currentEmployer.setImagePath(IMAGES_ROOT_FOLDER_PATH + COMPANY_IMAGES_ROOT_FOLDER_PATH
							+ "company_image_" + currentEmployer.getAccount().getId().toString() + ".png");
					serviceEmployer.save(currentEmployer);

					return "redirect:/employer/home?displayMessage=Photo uploaded successfully.";
				} else {
					return "redirect:/employer/home?displayErrorMessage=Please select an image file.";
				}
			}
		} catch (Exception e) {
			return "redirect:/employer/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/employer/home";
	}

	@PostMapping("/employer/job/post")
	public String postJob(Model model, @ModelAttribute("jobPostDTO") @Valid JobPostDTO jobPostDTO) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());

				// If employer has not purchased any package then don't allow them for Posting
				// Job.
				if (currentEmployer.getPackageId() == null && currentEmployer.getCurrentJobPostingCount() >= 3) {
					return "redirect:/employer?displayErrorMessage=You have consumed your free trial Job Posting limit. Please purchase a new plan from among the below available plans to continue.";
				}

				// If Job posting count is reached then ask the user to purchase the package
				if (currentEmployer.getPackageId() != null
						&& currentEmployer.getCurrentJobPostingCount() >= servicePackages
								.getPackageById(currentEmployer.getPackageId()).getJobPostingLimit()
						&& !servicePackages.getPackageById(currentEmployer.getPackageId()).getIsUnlimitedJobPosting()) {

					return "redirect:/employer?displayErrorMessage=You have consumed your Job Posting limit. Please purchase a new plan from among the below available plans to continue.";
				}
				if (jobPostDTO != null) {
					serviceJob.save(JobMapper.toJob(currentLoggedInUser, jobPostDTO));
				}
				// After successful posting job, increase the current job posting count
				currentEmployer.setCurrentJobPostingCount(currentEmployer.getCurrentJobPostingCount() + 1);
				serviceEmployer.save(currentEmployer);

				return "redirect:/employer/home?displayMessage=Job Posted Successfully.";
			}
		} catch (Exception e) {
			return "redirect:/employer/home?displayErrorMessage=Error: Something went wrong. Please try after sometime.";
		}

		return "redirect:/employer/home";
	}

	@PostMapping("/employer/cv/jobseekers")
	public String getJobseekersByCV(HttpServletRequest request, Model model,
			@ModelAttribute("jobseeker") @Valid SearchJobseekersDTO searchJobseekersDTO) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();
			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());

				// If employer has not purchased any package then don't allow them for CV search
				// more than 3 times
				// search.
				if (currentEmployer.getPackageId() == null && currentEmployer.getCurrentCvSearchCount() >= 3) {
					return "redirect:/employer?displayErrorMessage=You have consumed your free trial CV Search limit. Please purchase a new plan from among the below available plans to continue.";
				}

				// CV search count is reached then ask the user to purchase the package
				if (currentEmployer.getPackageId() != null
						&& currentEmployer.getCurrentCvSearchCount() >= servicePackages
								.getPackageById(currentEmployer.getPackageId()).getCvSearchLimit()
						&& !servicePackages.getPackageById(currentEmployer.getPackageId()).getIsUnlimitedCvSearch()) {

					return "redirect:/employer?displayErrorMessage=You have consumed your CV Search limit. Please purchase a new plan from among the below available plans to continue.";
				}

				List<Jobseeker> searchedJobseekers = serviceJobseeker.searchJobseekersWithExtraFilters(
						JobseekerMapper.toJobseeker(searchJobseekersDTO), searchJobseekersDTO);
				model.addAttribute("searchedJobseekers", searchedJobseekers);
				model.addAttribute("lowerLimit", 1);
				model.addAttribute("upperLimit", searchedJobseekers.size());
				model.addAttribute("headerMessage", "Jobseekers found as per the search criteria");
				model.addAttribute("sectors", serviceSector.getAllSectors());
				model.addAttribute("cities", serviceCity.getAllCities());
				model.addAttribute("countries", serviceCountry.getAllCountries());
				model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
				model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
				model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
				model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
				model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());
				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));
				model.addAttribute("currentEmployer", currentEmployer);
				model.addAttribute("packages", servicePackages.getAllPackages());

				// After successful search, increase the current cv search count
				currentEmployer.setCurrentCvSearchCount(currentEmployer.getCurrentCvSearchCount() + 1);
				serviceEmployer.save(currentEmployer);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return "redirect:/error";
		}

		return "searched_cv";
	}

	@GetMapping("/employer/cv/jobseekers")
	public String getJobseekersCVSearchPage(HttpServletRequest request, Model model) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();
			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());
				model.addAttribute("sectors", serviceSector.getAllSectors());
				model.addAttribute("cities", serviceCity.getAllCities());
				model.addAttribute("countries", serviceCountry.getAllCountries());
				model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
				model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
				model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
				model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
				model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());
				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));
				model.addAttribute("currentEmployer", currentEmployer);
				model.addAttribute("packages", servicePackages.getAllPackages());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return "redirect:/error";
		}

		return "cv_search";
	}

	@PostMapping("/buy")
	public String getOrderDetailsPage(Model model, @RequestParam("packageId") Long packageId) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();
			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());

				// Create here the order
				Packages curentPackage = servicePackages.getPackageById(packageId);
				Orders orders = new Orders(new Packages(packageId), currentEmployer, curentPackage.getSellingPrice(),
						curentPackage.getPrice() - curentPackage.getSellingPrice(), OrderStatusEnum.CREATED,
						LocalDateTime.now(), currentLoggedInUser.getId());

				serviceOrders.save(orders);

				model.addAttribute("sectors", serviceSector.getAllSectors());
				model.addAttribute("cities", serviceCity.getAllCities());
				model.addAttribute("countries", serviceCountry.getAllCountries());
				model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
				model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
				model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
				model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
				model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());
				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));
				model.addAttribute("currentEmployer", currentEmployer);
				model.addAttribute("packages", servicePackages.getAllPackages());
				model.addAttribute("package", curentPackage);
				model.addAttribute("order", orders);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return "redirect:/error";
		}

		return "order_details";
	}

	@PostMapping("/checkout")
	public String checkout(Model model, @RequestParam("packageId") Long packageId,
			@RequestParam("orderId") Long orderId) {

		try {
			Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();
			if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
				Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());

				// If amount paid success save order status as paid
				Packages curentPackage = servicePackages.getPackageById(packageId);
				Orders orders = serviceOrders.getOrderById(orderId);
				orders.setOrderStatus(OrderStatusEnum.PAID);
				serviceOrders.save(orders);

				// Set the packageId for the current user after successful payment
				currentEmployer.setPackageId(packageId);
				currentEmployer.setCurrentCvSearchCount(0);
				currentEmployer.setCurrentJobPostingCount(0);
				serviceEmployer.save(currentEmployer);

				model.addAttribute("sectors", serviceSector.getAllSectors());
				model.addAttribute("cities", serviceCity.getAllCities());
				model.addAttribute("countries", serviceCountry.getAllCountries());
				model.addAttribute("jobRoles", serviceJobRole.getAllJobRoles());
				model.addAttribute("companyIndustries", serviceCompanyIndustry.getAllCompanyIndustries());
				model.addAttribute("companyTypes", serviceCompanyType.getAllCompanyTypes());
				model.addAttribute("jobLevels", serviceJobLevel.getAllJobLevels());
				model.addAttribute("jobTypes", serviceJobType.getAllJobTypes());
				model.addAttribute("currentLoggedInUserEmail", currentLoggedInUser.getEmail());
				model.addAttribute("currentLoggedInUserCreatedOn", currentLoggedInUser.getCreatedOnFormatted());
				model.addAttribute("currentLoggedInUserLastLogin", currentLoggedInUser.getLastLoginFormatted());
				model.addAttribute("currentLoggedInUser", AccountMapper.toAccountEdit(currentLoggedInUser));
				model.addAttribute("currentEmployer", currentEmployer);
				model.addAttribute("packages", servicePackages.getAllPackages());
				model.addAttribute("package", curentPackage);
			}
		} catch (Exception e) {
			Orders orders = serviceOrders.getOrderById(orderId);
			orders.setOrderStatus(OrderStatusEnum.FAILED);
			serviceOrders.save(orders);
			log.error(e.getMessage());
			return "redirect:/error";
		}

		return "thank_you";
	}

	@PostMapping("/drop/email")
	public String dropEmail(Model model, @ModelAttribute("webContactUs") @Valid WebContactUs webContactUs) {

		try {
			serviceWebContactUs.save(webContactUs);
			model.addAttribute("contactName", webContactUs.getName());

			emailSenderService.sendEmailWithAttachment("mindful974@gmail.com", "Contact Us Form! Job Portal!",
					"<b>Name</b>: " + webContactUs.getName() + "<br/><b>Email</b>: " + webContactUs.getEmail()
							+ "<br/><b>Message</b>: " + webContactUs.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			return "redirect:/error";
		}
		return "contact_us_thank_you";
	}

	@PostMapping("/employer/drop/email")
	public String dropEmployerEmail(Model model,
			@ModelAttribute("employerContactUs") @Valid EmployerContactUs employerContactUs, BindingResult result) {

		try {
			if (result.hasErrors()) {
				Account currentLoggedInUser = userDetailsService.getCurrentLoggedInUser();

				if (currentLoggedInUser != null && serviceEmployer.isValidEmployer(currentLoggedInUser.getId())) {
					Employer currentEmployer = serviceEmployer.getEmployerByEmail(currentLoggedInUser.getEmail());

					model.addAttribute("currentEmployer", currentEmployer);
					model.addAttribute("countries", serviceCountry.getAllCountries());

					return "employers_contact";
				}
			}

			serviceEmployerContactUs.save(employerContactUs);
			model.addAttribute("contactName", employerContactUs.getName());

			Country country = serviceCountry.getCountryById(employerContactUs.getCountryId());

			emailSenderService.sendEmailWithAttachment("mindful974@gmail.com", "Employer Contact Us Form! Job Portal!",
					"<b>Name</b>: " + employerContactUs.getName() + "<br/><b>Email</b>: " + employerContactUs.getEmail()
							+ "<br/><b>Subject</b>: " + employerContactUs.getSubject() + "<br/><b>Message</b>: "
							+ employerContactUs.getMessage() + "<br/><b>Job Title</b>: "
							+ employerContactUs.getJobTitle() + "<br/><b>Company Name</b>: "
							+ employerContactUs.getCompanyName() + "<br/><b>Mobile Number</b>: "
							+ employerContactUs.getMobileNumber() + "<br/><b>Country</b>: " + country.getCountry());
		} catch (Exception e) {
			log.error(e.getMessage());
			return "redirect:/error";
		}
		return "contact_us_thank_you";
	}
}
