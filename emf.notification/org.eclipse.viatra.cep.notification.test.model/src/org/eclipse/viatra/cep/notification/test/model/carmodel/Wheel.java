/**
 */
package org.eclipse.viatra.cep.notification.test.model.carmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wheel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel#getCar <em>Car</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.CarmodelPackage#getWheel()
 * @model
 * @generated
 */
public interface Wheel extends EObject {
	/**
	 * Returns the value of the '<em><b>Car</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Car#getWheels <em>Wheels</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Car</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Car</em>' container reference.
	 * @see #setCar(Car)
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.CarmodelPackage#getWheel_Car()
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Car#getWheels
	 * @model opposite="wheels" transient="false"
	 * @generated
	 */
	Car getCar();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel#getCar <em>Car</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Car</em>' container reference.
	 * @see #getCar()
	 * @generated
	 */
	void setCar(Car value);

} // Wheel
