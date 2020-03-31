package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserDispoKey implements Serializable {
	
	 @Column(name = "user_id")
	    Long studentId;
	 
	    @Column(name = "disponibility_id")
	    Long dispoId;

		public Long getStudentId() {
			return studentId;
		}

		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}

		public Long getDispoId() {
			return dispoId;
		}

		public void setDispoId(Long dispoId) {
			this.dispoId = dispoId;
		}

		@Override
		public String toString() {
			return "UserDispoKey [studentId=" + studentId + ", dispoId=" + dispoId + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dispoId == null) ? 0 : dispoId.hashCode());
			result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UserDispoKey other = (UserDispoKey) obj;
			if (dispoId == null) {
				if (other.dispoId != null)
					return false;
			} else if (!dispoId.equals(other.dispoId))
				return false;
			if (studentId == null) {
				if (other.studentId != null)
					return false;
			} else if (!studentId.equals(other.studentId))
				return false;
			return true;
		}

		public UserDispoKey(Long studentId, Long dispoId) {
			super();
			this.studentId = studentId;
			this.dispoId = dispoId;
		}

		public UserDispoKey() {
			super();
		}

		
	    
}
