/**
 * 
 */
package pro.mossad.admin.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Home
 *
 */
@Entity
@Table(name = "category")
@NamedQueries({ @NamedQuery(name = "Category.findAll", query = "SELECT c from Category c") })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Category {

	@Id
	@SequenceGenerator(name = "category_sequence", allocationSize = 1, initialValue = 1020)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	private String header;

	private Boolean visible;

	@Column(name = "image_path", length = 120)
	private String imagePath;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category parent;

	private LocalDateTime created = LocalDateTime.now();

	private LocalDateTime updated;

	@Version
	private Integer version = 0;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * @return the visible
	 */
	public Boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the parent
	 */
	public Category getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Category parent) {
		this.parent = parent;
	}

	/**
	 * @return the updated
	 */
	public LocalDateTime getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the created
	 */
	public LocalDateTime getCreated() {
		return created;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Category category = (Category) obj;
		return Objects.equals(id, category.id) && Objects.equals(name, category.name)
				&& Objects.equals(header, category.header) && Objects.equals(visible, category.visible)
				&& Objects.equals(imagePath, category.imagePath) && Objects.equals(parent, category.parent)
				&& Objects.equals(created, category.created) && Objects.equals(updated, category.updated)
				&& Objects.equals(version, category.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, header, visible, imagePath, parent, created, updated, version);
	}

}
