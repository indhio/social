package com.indhio.architecture.abstracts;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

/**
 * @author Vinicius Nascimento
 * 
 */
public class ListenerEntity {

	@PostPersist
	public void postPersist(Object obj) {
	}

	@PostUpdate
	public void postUpdatet(Object obj) {
	}

	@PostRemove
	public void postRemove(Object obj) {
	}

}
