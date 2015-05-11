/**
 */
package org.eclipse.viatra.cep.notification.test.model.carmodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.CarmodelFactory
 * @model kind="package"
 * @generated
 */
public interface CarmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "carmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://example.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.viatra.cep.notification.test.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CarmodelPackage eINSTANCE = org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarImpl <em>Car</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarImpl
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarmodelPackageImpl#getCar()
	 * @generated
	 */
	int CAR = 0;

	/**
	 * The feature id for the '<em><b>Wheels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAR__WHEELS = 0;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAR__ENGINE = 1;

	/**
	 * The number of structural features of the '<em>Car</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Car</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.impl.WheelImpl <em>Wheel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.WheelImpl
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarmodelPackageImpl#getWheel()
	 * @generated
	 */
	int WHEEL = 1;

	/**
	 * The feature id for the '<em><b>Car</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEEL__CAR = 0;

	/**
	 * The number of structural features of the '<em>Wheel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Wheel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.impl.EngineImpl <em>Engine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.EngineImpl
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarmodelPackageImpl#getEngine()
	 * @generated
	 */
	int ENGINE = 2;

	/**
	 * The feature id for the '<em><b>Car</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__CAR = 0;

	/**
	 * The number of structural features of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Car <em>Car</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Car</em>'.
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Car
	 * @generated
	 */
	EClass getCar();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Car#getWheels <em>Wheels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Wheels</em>'.
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Car#getWheels()
	 * @see #getCar()
	 * @generated
	 */
	EReference getCar_Wheels();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Car#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Engine</em>'.
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Car#getEngine()
	 * @see #getCar()
	 * @generated
	 */
	EReference getCar_Engine();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel <em>Wheel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wheel</em>'.
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel
	 * @generated
	 */
	EClass getWheel();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel#getCar <em>Car</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Car</em>'.
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Wheel#getCar()
	 * @see #getWheel()
	 * @generated
	 */
	EReference getWheel_Car();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Engine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine</em>'.
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Engine
	 * @generated
	 */
	EClass getEngine();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.Engine#getCar <em>Car</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Car</em>'.
	 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.Engine#getCar()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_Car();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CarmodelFactory getCarmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarImpl <em>Car</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarImpl
		 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarmodelPackageImpl#getCar()
		 * @generated
		 */
		EClass CAR = eINSTANCE.getCar();

		/**
		 * The meta object literal for the '<em><b>Wheels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAR__WHEELS = eINSTANCE.getCar_Wheels();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAR__ENGINE = eINSTANCE.getCar_Engine();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.impl.WheelImpl <em>Wheel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.WheelImpl
		 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarmodelPackageImpl#getWheel()
		 * @generated
		 */
		EClass WHEEL = eINSTANCE.getWheel();

		/**
		 * The meta object literal for the '<em><b>Car</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHEEL__CAR = eINSTANCE.getWheel_Car();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.cep.notification.test.model.carmodel.impl.EngineImpl <em>Engine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.EngineImpl
		 * @see org.eclipse.viatra.cep.notification.test.model.carmodel.impl.CarmodelPackageImpl#getEngine()
		 * @generated
		 */
		EClass ENGINE = eINSTANCE.getEngine();

		/**
		 * The meta object literal for the '<em><b>Car</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__CAR = eINSTANCE.getEngine_Car();

	}

} //CarmodelPackage
