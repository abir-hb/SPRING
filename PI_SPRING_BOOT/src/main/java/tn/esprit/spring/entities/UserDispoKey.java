package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserDispoKey implements Serializable {
	
	 @Column(name = "user_id")
	    Long userId;
	 
	    @Column(name = "disponibility_id")
	    Long dispoId;

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Long getDispoId() {
			return dispoId;
		}

		public void setDispoId(Long dispoId) {
			this.dispoId = dispoId;
		}

		public UserDispoKey(Long userId, Long dispoId) {
			super();
			this.userId = userId;
			this.dispoId = dispoId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dispoId == null) ? 0 : dispoId.hashCode());
			result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
			if (userId == null) {
				if (other.userId != null)
					return false;
			} else if (!userId.equals(other.userId))
				return false;
			return true;
		}

		public UserDispoKey() {
			super();
		}

		

		
	    
}
