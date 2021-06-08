package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.JukeboxAdmin;

import javax.transaction.Transactional;

@Transactional
public interface JukeboxAdminRepository extends AbstractUserRepository<JukeboxAdmin>{

}
