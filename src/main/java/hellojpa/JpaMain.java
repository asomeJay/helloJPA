package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();

        Long beforeTime, afterTime;

        try {
            beforeTime = System.currentTimeMillis();
            Member findMember = em.find(Member.class, 1L);
            afterTime = System.currentTimeMillis();

            System.out.println("findMember : " + (afterTime - beforeTime));

            beforeTime = System.currentTimeMillis();
            Member findMember2 = em2.find(Member.class, 2L);
            afterTime = System.currentTimeMillis();

            System.out.println("findMember2 : " + (afterTime - beforeTime));

        } catch (Exception e) {
            System.out.println("ERROR");
        } finally {
            em.close();
            em2.close();
            emf.close();
        }
    }
}
