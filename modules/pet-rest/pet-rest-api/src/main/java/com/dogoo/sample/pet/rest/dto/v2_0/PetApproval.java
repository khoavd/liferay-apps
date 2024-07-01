package com.dogoo.sample.pet.rest.dto.v2_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author khoavu
 * @generated
 */
@Generated("")
@GraphQLName(description = "Pet model", value = "PetApproval")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "PetApproval")
public class PetApproval implements Serializable {

	public static PetApproval toDTO(String json) {
		return ObjectMapperUtil.readValue(PetApproval.class, json);
	}

	public static PetApproval unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(PetApproval.class, json);
	}

	@Schema(description = "The group's pet.")
	@Valid
	public AnimalGroup getAnimalGroupNew() {
		return animalGroupNew;
	}

	public void setAnimalGroupNew(AnimalGroup animalGroupNew) {
		this.animalGroupNew = animalGroupNew;
	}

	@JsonIgnore
	public void setAnimalGroupNew(
		UnsafeSupplier<AnimalGroup, Exception> animalGroupNewUnsafeSupplier) {

		try {
			animalGroupNew = animalGroupNewUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The group's pet.")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected AnimalGroup animalGroupNew;

	@Schema(description = "A list of the tag's pets.")
	@Valid
	public AnimalTag[] getAnimalTags() {
		return animalTags;
	}

	public void setAnimalTags(AnimalTag[] animalTags) {
		this.animalTags = animalTags;
	}

	@JsonIgnore
	public void setAnimalTags(
		UnsafeSupplier<AnimalTag[], Exception> animalTagsUnsafeSupplier) {

		try {
			animalTags = animalTagsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "A list of the tag's pets.")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected AnimalTag[] animalTags;

	@Schema
	public Date getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	@JsonIgnore
	public void setBirthOfDate(
		UnsafeSupplier<Date, Exception> birthOfDateUnsafeSupplier) {

		try {
			birthOfDate = birthOfDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Date birthOfDate;

	@Schema
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@JsonIgnore
	public void setBrief(
		UnsafeSupplier<String, Exception> briefUnsafeSupplier) {

		try {
			brief = briefUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String brief;

	@Schema
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@JsonIgnore
	public void setCreatedDate(
		UnsafeSupplier<Date, Exception> createdDateUnsafeSupplier) {

		try {
			createdDate = createdDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Date createdDate;

	@Schema
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String description;

	@Schema
	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}

	@JsonIgnore
	public void setExternalReferenceCode(
		UnsafeSupplier<String, Exception> externalReferenceCodeUnsafeSupplier) {

		try {
			externalReferenceCode = externalReferenceCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String externalReferenceCode;

	@Schema
	public Long getGender() {
		return gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	@JsonIgnore
	public void setGender(
		UnsafeSupplier<Long, Exception> genderUnsafeSupplier) {

		try {
			gender = genderUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long gender;

	@Schema
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long id;

	@Schema
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String name;

	@Schema
	@Valid
	public Status getStatus() {
		return status;
	}

	@JsonIgnore
	public String getStatusAsString() {
		if (status == null) {
			return null;
		}

		return status.toString();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonIgnore
	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Status status;

	@Schema
	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	@JsonIgnore
	public void setStatusDate(
		UnsafeSupplier<Date, Exception> statusDateUnsafeSupplier) {

		try {
			statusDate = statusDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Date statusDate;

	@Schema
	public Boolean getVaccine() {
		return vaccine;
	}

	public void setVaccine(Boolean vaccine) {
		this.vaccine = vaccine;
	}

	@JsonIgnore
	public void setVaccine(
		UnsafeSupplier<Boolean, Exception> vaccineUnsafeSupplier) {

		try {
			vaccine = vaccineUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Boolean vaccine;

	@Schema
	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	@JsonIgnore
	public void setWeight(
		UnsafeSupplier<Long, Exception> weightUnsafeSupplier) {

		try {
			weight = weightUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long weight;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetApproval)) {
			return false;
		}

		PetApproval petApproval = (PetApproval)object;

		return Objects.equals(toString(), petApproval.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (animalGroupNew != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"animalGroupNew\": ");

			sb.append(String.valueOf(animalGroupNew));
		}

		if (animalTags != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"animalTags\": ");

			sb.append("[");

			for (int i = 0; i < animalTags.length; i++) {
				sb.append(String.valueOf(animalTags[i]));

				if ((i + 1) < animalTags.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (birthOfDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"birthOfDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(birthOfDate));

			sb.append("\"");
		}

		if (brief != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"brief\": ");

			sb.append("\"");

			sb.append(_escape(brief));

			sb.append("\"");
		}

		if (createdDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(createdDate));

			sb.append("\"");
		}

		if (description != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(description));

			sb.append("\"");
		}

		if (externalReferenceCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(externalReferenceCode));

			sb.append("\"");
		}

		if (gender != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"gender\": ");

			sb.append(gender);
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (status != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(status);

			sb.append("\"");
		}

		if (statusDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(statusDate));

			sb.append("\"");
		}

		if (vaccine != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"vaccine\": ");

			sb.append(vaccine);
		}

		if (weight != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"weight\": ");

			sb.append(weight);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.sample.pet.rest.dto.v2_0.PetApproval",
		name = "x-class-name"
	)
	public String xClassName;

	@GraphQLName("Status")
	public static enum Status {

		PENDING("pending"), REJECT("reject"), APPROVED("approved"),
		TRASHED("trashed");

		@JsonCreator
		public static Status create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Status status : values()) {
				if (Objects.equals(status.getValue(), value)) {
					return status;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Status(String value) {
			_value = value;
		}

		private final String _value;

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}