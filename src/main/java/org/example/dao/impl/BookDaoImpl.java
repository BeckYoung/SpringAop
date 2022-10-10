package org.example.dao.impl;

import org.example.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("BookDaoImpl save...");
    }

    @Override
    public void update() {
        System.out.println("BookDaoImpl update...");
    }
}
