USE aeroparker;
CREATE TABLE customer_site(
customer_id BIGINT NOT NULL,
site_id BIGINT NULL,
UNIQUE (customer_id, site_id),
FOREIGN KEY (customer_id) REFERENCES customers(id),
FOREIGN KEY (site_id) REFERENCES sites(id)
);



