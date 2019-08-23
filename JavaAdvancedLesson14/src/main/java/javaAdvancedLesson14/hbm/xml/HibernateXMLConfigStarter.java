package javaAdvancedLesson14.hbm.xml;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateXMLConfigStarter {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//				.applySettings(configuration.getProperties()).build();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

//				//create
//				Card card = new Card(1, "Card 1");
//				session.persist(person);

//				//read single entity
//				Card cardFromDB = (Card) session.get(Card.class, 1);
//				System.out.println(cardFromDB);

//				//get All from DB
//				@SuppressWarnings("unchecked")
//				List<Card> listOfCards = session.createCriteria(Card.class).list();
//				listOfCards.forEach(System.out::println);

//				//update entity
//				Card cardForUpdate = (Card) session.get(Card.class, 1);
//				System.out.println(cardForUpdate);
//				cardForUpdate.setName("New Card");
//				session.persist(cardForUpdate);

//				//delete
//				Card cardForDelete = (Card) session.get(Card.class, 1);
//				session.delete(cardForDelete);

		// create
		Card card = new Card(1, "Card 1");
		Item item1 = new Item(1234);
		Item item2 = new Item(2345);
		Item item3 = new Item(3456);
		Item item4 = new Item(4567);
		Item item5 = new Item(5678);
		card.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4, item5)));

		session.persist(card);

		@SuppressWarnings("unchecked")
		List<Card> listOfCards = session.createCriteria(Card.class).list();
		listOfCards.forEach(System.out::println);

		transaction.commit();
		session.close();
	}
}
