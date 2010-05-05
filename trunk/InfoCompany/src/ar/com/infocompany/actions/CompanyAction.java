package ar.com.infocompany.actions;

import java.util.Iterator;
import java.util.List;

import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

import ar.com.infocompany.entities.Company;
import ar.com.infocompany.entities.Field;
import ar.com.infocompany.services.IModelService;

import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Company company = new Company();
	private List<Company> companies;
	private IModelService modelService;
	private Cloud cloud;
	private List<Field> fields;
	private String nameField; 
	
	public Cloud getCloud() {
		return cloud;
	}

	public void setCloud(Cloud cloud) {
		this.cloud = cloud;
	}

	public IModelService getModelService() {
		return modelService;
	}
	
	public void setModelService(IModelService modelService) {
		this.modelService = modelService;
	}
	
	public String getAllCompanies() {
		companies = modelService.getAllCompanies();
		this.cloud = cloudTags();
		return "success";
	}
	
	public String insertOrUpdateCompany(){
			if (company.getCompanyId() == null) {
				modelService.insertCompany(company);
			}else {
				modelService.updateCompany(company);
			}
		return "success";
	}
	
	public String deleteCompany(){
		modelService.deleteCompany(company.getCompanyId());
		return "success";
	}
	
	public String setUpForInsertOrUpdateCompany(){
		if (company != null && company.getCompanyId() != null) {
			company = modelService.getCompany(company.getCompanyId());
		}
		if(fields == null)
		{
			fields = modelService.getAllFields();
		}
		return "success";
	}
	
	public List<Company> getCompanies() {
		return companies;
	}
	
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Cloud cloudTags() {
        /* Creación del objeto nube */
        Cloud cloud = new Cloud();
        /* Inserción de las tags en la nube */
        int weith=35;
        for (Company company : companies) {
        	cloud.addTag(new Tag(company.getName(), company.getName(), weith - (weith/4)));
        	weith=weith-(weith/4);
        }
        /* Establecimiento de propiedades de la nube  */
        cloud.setMaxTagsToDisplay(15);
        cloud.setMaxWeight(30);
        cloud.setMinWeight(8);
        /* Objeto creado  */
        return cloud;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public String getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField = nameField;
		int idField = Integer.parseInt(nameField);

		if(fields == null)
			fields = modelService.getAllFields();
		
		for(Field field: fields)
		{
			if(field.getFieldId() == idField)
			{
				company.setCompanyField(field);
				break;
			}
		}	
	}
	
	
}