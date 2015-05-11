/**
 */
package org.eclipse.viatra.cep.notification.test.model.carmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Car</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Car#getWheels <em>Wheels</em>}</li>
 *   <li>{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Car#getEngine <em>Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.CarmodelPackage#getCar()
 * @model
 * @generated
 */
public interface Car extends EObject {
	/**
	 * Returns the value of the '<em><b>Wheels</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel#getCar <em>Car</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheels</em>' containment reference list.
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.CarmodelPackage#getCar_Wheels()
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel#getCar
	 * @model opposite="car" containment="true"
	 * @generated
	 */
	EList<Wheel> getWheels();

	/**
	 * Returns the value of the '<em><b>Engine</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Engine#getCar <em>Car</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine</em>' containment reference.
	 * @see #setEngine(Engine)
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.CarmodelPackage#getCar_Engine()
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Engine#getCar
	 * @model opposite="car" containment="true"
	 * @generated
	 */
	Engine getEngine();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Car#getEngine <em>Engine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine</em>' containment reference.
	 * @see #getEngine()
	 * @generated
	 */
	void setEngine(Engine value);

} // Car
