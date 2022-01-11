package com.mindfulqatar.jobportal.repositories;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.mindfulqatar.jobportal.entities.Job;
import com.mindfulqatar.jobportal.entities.City;
import com.mindfulqatar.jobportal.entities.Employer;

public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {
	List<Job> findByJobRole(Long jobRoleId);

	List<Job> findByCompanyIndustry(Long companyIndustryId);

	List<Job> findByCity(City city);

	@Query(value = "SELECT AVG(monthly_salary) FROM Job WHERE job_title ilike ?1 OR description ilike ?1 OR skills ilike ?1", nativeQuery = true)
	Long getAVGMonthlySalaryByJobTitle(String jobTitle);

	@Query(value = "SELECT AVG(monthly_salary) FROM Job WHERE job_role = ?1", nativeQuery = true)
	Long getAVGMonthlySalaryByJobRole(Long jobRole);

	@Query(value = "SELECT AVG(monthly_salary) FROM Job WHERE city_id = ?1", nativeQuery = true)
	Long getAVGMonthlySalaryByLocation(Long cityId);

	@Query(value = "SELECT AVG(monthly_salary) FROM Job WHERE employer_id = ?1", nativeQuery = true)
	Long getAVGMonthlySalaryByEmployer(Long employerId);

	@Query(value = "SELECT AVG(monthly_salary) FROM Job WHERE (job_title ilike ?1 OR description ilike ?1 OR skills ilike ?1) AND city_id = ?2", nativeQuery = true)
	Long getAVGMonthlySalaryByJobTitleAndLocation(String jobTitle, Long cityId);

	@Query(value = "SELECT * FROM Job WHERE city_id = ?1 AND (job_title ilike ?2 OR description ilike ?2)", nativeQuery = true)
	List<Job> findByCityAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long cityId, String searchStr);

	List<Job> findByJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(String searchStr1, String searchStr2);

	@Query(value = "SELECT * FROM Job WHERE job_role = ?1 AND (job_title ilike ?2 OR description ilike ?2)", nativeQuery = true)
	List<Job> findByJobRoleAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long jobRoleId, String searchStr);

	long count();

	int countByJobRole(Long jobRoleId);

	int countByCompanyIndustry(Long companyIndustryId);

	int countByCity(City city);

	int countByEmployer(Employer emp);

	@Query(value = "SELECT Count(*) FROM Job WHERE city_id = ?1 AND (job_title ilike ?2 OR description ilike ?2)", nativeQuery = true)
	int countByCityAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long cityId, String searchStr);

	int countByJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(String searchStr1, String searchStr2);

	@Query(value = "SELECT Count(*) FROM Job WHERE job_role = ?1 AND (job_title ilike ?2 OR description ilike ?2)", nativeQuery = true)
	int countByJobRoleAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long jobRoleId, String searchStr);

	@Query(value = "SELECT Count(*) FROM Job WHERE company_industry = ?1 AND (job_title ilike ?2 OR description ilike ?2)", nativeQuery = true)
	int countByCompanyIndustryAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long companyIndustryId,
			String searchStr);

	@Query(value = "SELECT Count(*) FROM Job WHERE company_industry = ANY(SELECT id FROM company_Industry WHERE sector_id = ?1) AND (job_title ilike ?2 OR description ilike ?2)", nativeQuery = true)
	int countBySectorAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long sectorId, String searchStr);

	@Query(value = "SELECT COUNT(*) FROM Job WHERE updated_on BETWEEN CAST(?1 As TIMESTAMP) AND CAST(?2 As TIMESTAMP) AND (job_title ilike ?3 OR description ilike ?3)", nativeQuery = true)
	int countJobsBetweenDatesAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(LocalDateTime date1,
			LocalDateTime date2, String searchStr);

	@Query(value = "SELECT Count(*) FROM Job WHERE employer_id = ?1 AND (job_title ilike ?2 OR description ilike ?2)", nativeQuery = true)
	int countByEmployerAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long employerId, String searchStr);

	@Query(value = "SELECT Count(*) FROM Job WHERE company_industry = ?1 AND city_id = ?2", nativeQuery = true)
	int countByCompanyIndustryAndCityId(Long companyIndustryId, Long cityId);

	@Query(value = "SELECT job_id from jobseeker_job_map GROUP BY job_id ORDER BY COUNT(job_id) DESC LIMIT ?1", nativeQuery = true)
	List<BigInteger> getTopNPopularJobIds(int n);

	@Query(value = "SELECT Count(*) FROM Job j LEFT OUTER JOIN Employer e ON j.employer_id = e.id WHERE (j.job_title ilike ?2 OR j.description ilike ?2) AND e.company_type=?1", nativeQuery = true)
	int countByCompanyTypeAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long companyType, String searchStr);

	@Query(value = "SELECT Count(*) FROM Job WHERE (job_title ilike ?2 OR description ilike ?2) AND job_type=?1", nativeQuery = true)
	int countByJobTypeAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long jobId, String searchStr);

	@Query(value = "SELECT Count(*) FROM Job WHERE (job_title ilike ?2 OR description ilike ?2) AND job_level=?1", nativeQuery = true)
	int countByJobLevelAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(Long jobLevel, String searchStr);

	@Query(value = "SELECT Count(*) FROM Job WHERE (job_title ilike ?2 OR description ilike ?2) AND required_gender ilike ?1", nativeQuery = true)
	int countByGenderAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(String gender, String searchStr);

	@Query(value = "SELECT DISTINCT COUNT(job_id) from jobseeker_job_map", nativeQuery = true)
	long countJobsApplied();

	@Query(value = "SELECT DISTINCT COUNT(jobseeker_id) from jobseeker_job_map", nativeQuery = true)
	long countJobseekersApplied();

	List<Job> findByEmployer(Employer employer);
}
