package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

  private final Stack stack = new Stack();

  @Test
  @DisplayName("Create the empty list (instancier la classe stack)")
    void should_create_an_empty_stack(){
      assertTrue((stack.isEmpty()));
  }

  @Test
  @DisplayName("Add an element (int) to the list")
  void should_push_one_element_to_the_list(){
    stack.pushElement(2);
    assertEquals(1, stack.getSize());
  }

/*  @Test
  @DisplayName("Verify if the list has an element in it")
  void should_return_a_not_empty_list(){
    stack.pushElement(2);
    assertFalse((stack.isEmpty()));
  }*/

  @Test
  @DisplayName("Verify if the element added in the stack list is correctly returned")
  void should_return_the_element_we_have_just_added(){
    stack.pushElement(3);
    assertEquals(3, stack.getLastElement());
  }

  @Test
  @DisplayName("Pop an element from the stack list")
  void should_pop_an_element(){
    stack.pushElement(4);
    assertFalse(stack.isEmpty());
    stack.popLastElement();
    assertTrue(stack.isEmpty());
  }

  @Test
  @DisplayName("Can't pop in an empty list")
  void should_not_pop_if_the_list_is_empty(){
    //vérifie qu'une exception est levée
    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
      stack.popLastElement(); // Code qui devrait lancer l'exception (peut être remplacé par un lambda ::)
    });
    //Vérifie le message de l'exception
    assertEquals("can't pop an empty list", exception.getMessage());

    //OU try catch
    try {
      stack.popLastElement();
      fail("Expected RuntimeException was not thrown"); // Le test échoue si on arrive ici
    } catch (RuntimeException e) {
      assertEquals("can't pop an empty list", e.getMessage());
    }
  }

  @Test
  @DisplayName("Add 2 stacks in the list")
  void should_add_two_stacks_in_the_list(){
    stack.pushElement(5);
    stack.pushElement(6);
    assertEquals(2,stack.getSize());
  }

  @Test
  @DisplayName("Add two elements, pop one, must remain one element in the list")
  void should_add_two_elements_then_remove_one_so_the_size_is_equals_one(){
    stack.pushElement(5);
    stack.pushElement(6);
    stack.popLastElement();
    assertEquals(1,stack.getSize());
  }

  @Test
  @DisplayName("Add two elements, pop two elements, the list must be empty")
  void should_add_two_elements_then_remove_them_the_list_must_be_empty(){
    stack.pushElement(5);
    stack.pushElement(6);
    stack.popLastElement();
    stack.popLastElement();
    assertEquals(0,stack.getSize());
  }

  @Test
  @DisplayName("Add two elements, pop one, must remain the older one")
  void should_remain_the_oldest_elements_in_the_list(){
    stack.pushElement(5); //oldest element
    stack.pushElement(6);
    //Last In First Out Paradigm
    stack.popLastElement();
    assertEquals(5, stack.getLastElement());
  }
}
